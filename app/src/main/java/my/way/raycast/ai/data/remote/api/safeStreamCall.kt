package my.way.raycast.ai.data.remote.api

import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.utils.io.readUTF8Line
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import my.way.raycast.core.domain.util.NetworkError
import my.way.raycast.core.domain.util.Result
import java.nio.channels.UnresolvedAddressException


/**
 * A specialized safeCall for streaming.
 * Instead of returning Result<T>, it returns a Flow<Result<T, NetworkError>>.
 */
inline fun <reified T> safeStreamCall(
    crossinline execute: suspend () -> HttpResponse,
): Flow<Result<T, NetworkError>> = flow {
    val json = Json { ignoreUnknownKeys = true }

    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        emit(Result.Error(NetworkError.NO_INTERNET))
        return@flow
    } catch (e: Exception) {
        currentCoroutineContext().ensureActive() // Don't swallow cancellation
        emit(Result.Error(NetworkError.UNKNOWN))
        return@flow
    }

    // 1. Check HTTP Status (Reusing your logic)
    if (response.status.value !in 200..299) {
        val error = when (response.status.value) {
            408 -> NetworkError.REQUEST_TIMEOUT
            429 -> NetworkError.TOO_MANY_REQUESTS
            in 500..599 -> NetworkError.SERVER_ERROR
            else -> NetworkError.UNKNOWN
        }
        emit(my.way.raycast.core.domain.util.Result.Error(error))
        return@flow
    }

    // 2. Stream the Body
    try {
        val channel = response.bodyAsChannel()
        while (!channel.isClosedForRead) {
            val line = channel.readUTF8Line() ?: break

            if (line.startsWith("data:")) {
                val jsonData = line.removePrefix("data:").trim()
                if (jsonData == "[DONE]") break

                try {
                    // Deserialize the chunk to the generic type T
                    val chunk = json.decodeFromString<T>(jsonData)
                    emit(Result.Success(chunk))
                } catch (e: Exception) {
                    // Malformed JSON chunk: Log it, but don't crash the flow
                    e.printStackTrace()
                }
            }
        }
    } catch (e: Exception) {
        emit(Result.Error(NetworkError.SERIALIZATION))
    }
}
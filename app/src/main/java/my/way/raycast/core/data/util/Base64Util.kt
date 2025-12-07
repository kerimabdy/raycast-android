package my.way.raycast.core.data.util

import kotlinx.serialization.json.Json
import java.util.Base64

object Base64Util {
    val json = Json { ignoreUnknownKeys = true }

    inline fun <reified T> decodeFromBase64(base64String: String): Result<T> = runCatching {
        val decodedBytes = Base64.getDecoder().decode(base64String)
        val jsonString = String(decodedBytes, Charsets.UTF_8)
        json.decodeFromString<T>(jsonString)
    }

    fun encodeToBase64(jsonString: String): String {
        return Base64.getEncoder().encodeToString(jsonString.toByteArray(Charsets.UTF_8))
    }
}
package my.way.raycast.ai.domain.model

sealed class StreamEvent {
    data class Chunk(val content: String) : StreamEvent()
    object Finished : StreamEvent()
}
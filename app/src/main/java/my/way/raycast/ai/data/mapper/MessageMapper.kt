package my.way.raycast.ai.data.mapper

import my.way.raycast.ai.data.local.entity.MessageEntity
import my.way.raycast.ai.data.remote.dto.GrokResponseDto
import my.way.raycast.ai.data.remote.dto.GrokStreamResponseDto
import my.way.raycast.ai.domain.model.Message

fun MessageEntity.toDomain(): Message = Message(
    id = this.id,
    content = this.content,
    isUser = this.isUser,
    timestamp = this.timestamp,
)


fun Message.toEntity(): MessageEntity = MessageEntity(
    id = this.id,
    content = this.content,
    isUser = this.isUser,
    timestamp = this.timestamp,
)

fun GrokResponseDto.toMessage() : Message = Message(
    content = this.choices.first().message.content,
    isUser = false,
    timestamp = System.currentTimeMillis(),
)

fun GrokStreamResponseDto.toChunkStringOrNull() : String? = this.choices.first().delta.content
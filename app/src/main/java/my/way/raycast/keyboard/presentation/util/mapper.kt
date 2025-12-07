package my.way.raycast.keyboard.presentation.util

import my.way.raycast.ai.domain.model.AiRequest
import my.way.raycast.command.domain.model.Command

fun Command.AICommand.toAiRequest(selection: String): AiRequest {
    val prompt = this.promptTemplate.replace("{selection}", selection)
    return AiRequest(
        prompt = prompt,
        temperature = this.temperature,
        maxToken = 512
    )
}
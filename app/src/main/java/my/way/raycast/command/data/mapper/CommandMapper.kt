package my.way.raycast.command.data.mapper

import my.way.raycast.command.data.eso.AICommandEso
import my.way.raycast.command.data.eso.QuicklinkEso
import my.way.raycast.command.data.eso.SnippetEso
import my.way.raycast.command.data.local.entity.CommandEntity
import my.way.raycast.command.data.remote.dto.CommandDto
import my.way.raycast.command.domain.model.Command
import my.way.raycast.command.domain.model.CommandType
import my.way.raycast.core.data.util.Base64Util
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun CommandEntity.toDomain(): Command {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    return when {
        this.kind == "quicklink" -> {
            val decoded = Base64Util.decodeFromBase64<QuicklinkEso>(this.value).getOrThrow()
            Command.Quicklink(
                clientUpdatedAt = Instant.parse(clientUpdatedAt),
                createdAt = Instant.parse(createdAt),
                id = id,
                kind = CommandType.fromString(kind),
                updatedAt = Instant.parse(updatedAt),
                version = version,
                iconName = decoded.iconName,
                isEnabled = decoded.isEnabled,
                name = decoded.name,
                openCount = decoded.openCount,
                updatedAtLocal = LocalDateTime.parse(decoded.updatedAt, formatter),
                urlString = decoded.urlString,
                uuid = decoded.uuid
            )
        }

        this.kind == "aiCommand" -> {
            val decoded = Base64Util.decodeFromBase64<AICommandEso>(this.value).getOrThrow()
            Command.AICommand(
                clientUpdatedAt = Instant.parse(clientUpdatedAt),
                createdAt = Instant.parse(createdAt),
                id = id,
                kind = CommandType.fromString(kind),
                updatedAt = Instant.parse(updatedAt),
                version = version,
                accessedAt = LocalDateTime.parse(decoded.accessedAt, formatter),
                count = decoded.count,
                createdAtLocal = LocalDateTime.parse(decoded.createdAt, formatter),
                highlightEdits = decoded.highlightEdits,
                iconName = decoded.iconName,
                model = decoded.model,
                modifiedAt = LocalDateTime.parse(decoded.modifiedAt, formatter),
                promptTemplate = decoded.promptTemplate,
                temperature = decoded.temperature,
                title = decoded.title,
                uuid = decoded.uuid,
            )
        }

        this.kind == "snippet" -> {
            val decoded = Base64Util.decodeFromBase64<SnippetEso>(this.value).getOrThrow()
            Command.Snippet(
                id = id,
                clientUpdatedAt = Instant.parse(clientUpdatedAt),
                createdAt = Instant.parse(createdAt),
                updatedAt = Instant.parse(updatedAt),
                kind = CommandType.fromString(kind),
                version = version,
                accessedAt = LocalDateTime.parse(decoded.accessedAt, formatter),
                alias = decoded.alias,
                category = decoded.category,
                copyCount = decoded.copyCount,
                createdAtLocal = LocalDateTime.parse(decoded.createdAt, formatter),
                modifiedAt = LocalDateTime.parse(decoded.modifiedAt, formatter),
                name = decoded.name,
                text = decoded.text
            )

        }

        else -> {
            Command.Unknown(
                clientUpdatedAt = Instant.parse(clientUpdatedAt),
                createdAt = Instant.parse(createdAt),
                id = id,
                kind = CommandType.fromString(kind),
                updatedAt = Instant.parse(updatedAt),
                version = version
            )
        }
    }
}

fun Command.toEntity(): CommandEntity {
    return when {
        this is Command.Quicklink -> {
            val quicklinkEso = QuicklinkEso(
                iconName = iconName,
                isEnabled = isEnabled,
                name = name,
                openCount = openCount,
                updatedAt = updatedAtLocal.toString(),
                urlString = urlString,
                uuid = uuid
            )
            val encodedCommand =
                Base64Util.encodeToBase64(
                    Base64Util.json.encodeToString(quicklinkEso)
                )
            CommandEntity(
                clientUpdatedAt = clientUpdatedAt.toString(),
                createdAt = createdAt.toString(),
                id = id,
                kind = kind.toString(),
                updatedAt = updatedAt.toString(),
                value = encodedCommand,
                version = version
            )
        }

        this is Command.AICommand -> {
            val aiCommandEso = AICommandEso(
                accessedAt = accessedAt.toString(),
                count = count,
                createdAt = createdAtLocal.toString(),
                highlightEdits = highlightEdits,
                iconName = iconName,
                model = model,
                modifiedAt = modifiedAt.toString(),
                promptTemplate = promptTemplate,
                temperature = temperature,
                title = title,
                uuid = uuid
            )
            val encodedCommand =
                Base64Util.encodeToBase64(Base64Util.json.encodeToString(aiCommandEso))
            CommandEntity(
                clientUpdatedAt = clientUpdatedAt.toString(),
                createdAt = createdAt.toString(),
                id = id,
                kind = kind.toString(),
                updatedAt = updatedAt.toString(),
                value = encodedCommand,
                version = version
            )
        }

        else -> {
            throw Exception("Unsupported command type")
        }

    }
}


fun CommandDto.toEntity(): CommandEntity {
    return CommandEntity(
        clientUpdatedAt = clientUpdatedAt,
        createdAt = createdAt,
        id = id,
        kind = kind,
        updatedAt = updatedAt,
        value = value,
        version = version
    )
}
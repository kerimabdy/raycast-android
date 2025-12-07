package my.way.raycast.core.presentation.util

import java.time.Duration
import java.time.LocalDateTime

fun formatRelativeTime(dateTime: LocalDateTime): String {
    val now = LocalDateTime.now()
    val duration = Duration.between(dateTime, now)

    return when {
        duration.seconds < 60 -> {
            val seconds = duration.seconds
            "Recently"
        }
        duration.toMinutes() < 60 -> {
            val minutes = duration.toMinutes()
            if (minutes == 1L) "$minutes minute ago" else "$minutes minutes ago"
        }
        duration.toHours() < 24 -> {
            val hours = duration.toHours()
            if (hours == 1L) "$hours hour ago" else "$hours hours ago"
        }
        duration.toDays() < 7 -> {
            val days = duration.toDays()
            if (days == 1L) "$days day ago" else "$days days ago"
        }
        duration.toDays() < 30 -> {
            val weeks = duration.toDays() / 7
            if (weeks == 1L) "$weeks week ago" else "$weeks weeks ago"
        }
        duration.toDays() < 365 -> {
            val months = duration.toDays() / 30
            if (months == 1L) "$months month ago" else "$months months ago"
        }
        else -> {
            val years = duration.toDays() / 365
            if (years == 1L) "$years year ago" else "$years years ago"
        }
    }
}

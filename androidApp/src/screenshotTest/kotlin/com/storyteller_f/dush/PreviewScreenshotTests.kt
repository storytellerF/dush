package com.storyteller_f.dush

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tools.screenshot.PreviewTest
import com.storyteller_f.dush.agent.data.ChatMessageEntity
import com.storyteller_f.dush.agent.data.MessageRole
import com.storyteller_f.dush.agent.data.MessageStatus
import com.storyteller_f.dush.agent.ui.ListCard
import com.storyteller_f.dush.agent.ui.MessageRow

@PreviewTest
@Preview(showBackground = true)
@Composable
fun UserMessagePreview() {
    MaterialTheme {
        MessageRow(
            ChatMessageEntity(
                id = "1",
                threadId = "t1",
                role = MessageRole.User,
                content = "Hello, how are you?",
                status = MessageStatus.Complete,
                createdAt = 0,
                updatedAt = 0,
                workerId = null,
            )
        )
    }
}

@PreviewTest
@Preview(showBackground = true)
@Composable
fun AssistantMessagePreview() {
    MaterialTheme {
        MessageRow(
            ChatMessageEntity(
                id = "2",
                threadId = "t1",
                role = MessageRole.Assistant,
                content = "I'm doing well, thank you! How can I help you today?",
                status = MessageStatus.Complete,
                createdAt = 0,
                updatedAt = 0,
                workerId = null,
            )
        )
    }
}

@PreviewTest
@Preview(showBackground = true)
@Composable
fun StreamingMessagePreview() {
    MaterialTheme {
        MessageRow(
            ChatMessageEntity(
                id = "3",
                threadId = "t1",
                role = MessageRole.Assistant,
                content = "",
                status = MessageStatus.Streaming,
                createdAt = 0,
                updatedAt = 0,
                workerId = null,
            )
        )
    }
}

@PreviewTest
@Preview(showBackground = true)
@Composable
fun ListCardPreview() {
    MaterialTheme {
        ListCard(
            title = "Gemma 2B",
            subtitle = "Available | LiterTLM | 1024 MB",
            onClick = {},
        )
    }
}

@PreviewTest
@Preview(showBackground = true)
@Composable
fun ChatConversationPreview() {
    val messages = listOf(
        ChatMessageEntity("1", "t1", MessageRole.User, "What is Kotlin?", MessageStatus.Complete, 0, 0, null),
        ChatMessageEntity("2", "t1", MessageRole.Assistant, "Kotlin is a modern programming language.", MessageStatus.Complete, 0, 0, null),
        ChatMessageEntity("3", "t1", MessageRole.User, "Tell me more", MessageStatus.Complete, 0, 0, null),
        ChatMessageEntity("4", "t1", MessageRole.Assistant, "", MessageStatus.Streaming, 0, 0, null),
    )
    MaterialTheme {
        Surface {
            Column(
                Modifier.fillMaxWidth().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                messages.forEach { MessageRow(it) }
            }
        }
    }
}

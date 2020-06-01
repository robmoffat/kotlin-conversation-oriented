package com.github.deutschebank.symphony.cop.local

import com.github.deutschebank.symphony.cop.Conversation
import com.github.deutschebank.symphony.cop.Message
import com.github.deutschebank.symphony.cop.parts.Tag

data class TextMessage(override val conversation: Conversation, val text: String, val tags : List<Tag> = emptyList()) : Message {


    override fun <T> only(matching: Class<T>): List<T> {
        if (matching == Tag::class) {
            return tags as List<T>
        } else {
            return emptyList()
        }
    }

}
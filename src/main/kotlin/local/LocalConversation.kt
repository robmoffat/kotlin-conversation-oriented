package com.github.deutschebank.symphony.cop.local

import com.github.deutschebank.symphony.cop.Conversation
import com.github.deutschebank.symphony.cop.filter.Filter
import com.github.deutschebank.symphony.cop.Message
import com.github.deutschebank.symphony.cop.Participant

data class LocalConversation(override val name: String, override val members: MutableSet<Participant>, val messages: MutableList<Message> = mutableListOf()) : Conversation {

    override fun post(m: Message) {
        messages.add(0, m)
    }

    override fun getLast(f: Filter): Message? {
        return messages
            .filter { f.test(it) }
            .single()
    }

    override fun getAll(f: Filter): Sequence<Message> {
        return messages
            .filter { f.test(it) }
            .asSequence()
    }


}

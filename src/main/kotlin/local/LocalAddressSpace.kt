package com.github.deutschebank.symphony.cop.local

import com.github.deutschebank.symphony.cop.AddressSpace
import com.github.deutschebank.symphony.cop.Conversation
import com.github.deutschebank.symphony.cop.Participant

/**
 * An in-memory, transient implementation of an address space, that can be used for temporary value storage or testing
 */
class LocalAddressSpace: AddressSpace {

    private val conversations : MutableMap<String, Conversation> = mutableMapOf()

    override fun getConversation(
        name: String,
        members: Set<Participant>,
        properties: Map<String, String>
    ): Conversation {
        val out = conversations.getOrPut(name) { LocalConversation(name, members.toMutableSet(), mutableListOf()) }
        out.members.addAll(members)
        return out
    }
}
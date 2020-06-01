package com.github.deutschebank.symphony.cop

/**
 * An address space is a set of conversations, which at least all have unique names within the space.
 */
interface AddressSpace {

    /**
     * Creates, or returns an existing, conversation containing $members.
     * If the conversation already exists, new members may be added.
     */
    fun getConversation(name: String, members: Set<Participant> = emptySet(), properties: Map<String, String> = emptyMap()) : Conversation
}
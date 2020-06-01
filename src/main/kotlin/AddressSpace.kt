package com.github.deutschebank.cop

/**
 * An address space is a set of conversations,
 */
interface AddressSpace {

    fun conversation(name: String, members: List<Participant>, properties: Map<String, String>) : Conversation

}
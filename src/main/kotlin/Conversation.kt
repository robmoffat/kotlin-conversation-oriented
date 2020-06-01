package com.github.deutschebank.symphony.cop

import com.github.deutschebank.symphony.cop.filter.Filter

interface Conversation : Addressable {

    val name : String

    val members : MutableSet<Participant>

    /**
     * Sends the message $m to the conversation
     */
    fun post(m: Message)

    /**
     * Returns the last message matching a given filter $f
     */
    fun getLast(f: Filter): Message?

    /**
     * Returns a Sequence of messages, from latest to earliest, matching the filter.
     * Sequences are evaluated lazily.
     */
    fun getAll(f: Filter): Sequence<Message>
}
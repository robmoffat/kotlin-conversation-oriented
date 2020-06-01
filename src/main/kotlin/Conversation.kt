package com.github.deutschebank.cop

interface Conversation : Addressable {

    val name()

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
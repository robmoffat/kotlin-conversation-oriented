package com.github.deutschebank.symphony.cop

interface Message {

    /**
     * Conversation that the message belongs to.
     */
    val conversation: Conversation

    /**
     * Returns all the parts of the message matching the class parameter.
     */
    fun <T> only(matching: Class<T>) : List<T>

}
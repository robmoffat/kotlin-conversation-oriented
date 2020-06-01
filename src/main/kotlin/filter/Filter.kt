package com.github.deutschebank.symphony.cop.filter

import com.github.deutschebank.symphony.cop.Message
import java.util.function.Predicate

typealias Filter = Predicate<Message>


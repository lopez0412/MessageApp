package com.loptech.messageapp.domain.model

data class SendingMessage(
    val messageId: Int,
    val datetime: String,
    val confirmationCode: String
    )

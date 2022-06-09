package com.loptech.messageapp.data.model

import com.loptech.messageapp.data.database.entities.MessageEntity
import com.loptech.messageapp.data.database.entities.SendingMessageEntity
import com.loptech.messageapp.domain.model.Message
import com.loptech.messageapp.domain.model.SendingMessage

data class SendingMessageModel(
    val messageId: Int,
    val datetime: String,
    val confirmationCode: String
)

fun SendingMessageModel.toDomain() = SendingMessage(messageId,datetime,confirmationCode)
fun SendingMessageEntity.toDomain() = SendingMessage(messageId,datetime,confirmationCode)

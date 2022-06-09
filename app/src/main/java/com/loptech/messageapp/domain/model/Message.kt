package com.loptech.messageapp.domain.model

import com.loptech.messageapp.data.database.entities.MessageEntity
import com.loptech.messageapp.data.model.MessageModel

data class Message(
    val datetime: String,
    val to: String,
    val message: String
)

fun MessageModel.toDomain() = Message(datetime,to,message)
fun MessageEntity.toDomain() = Message(datetime,to,message)
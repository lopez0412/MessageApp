package com.loptech.messageapp.data

import com.loptech.messageapp.data.database.dao.MessageDao
import com.loptech.messageapp.data.database.dao.SendingMessageDao
import com.loptech.messageapp.data.database.entities.MessageEntity
import com.loptech.messageapp.data.database.entities.SendingMessageEntity
import com.loptech.messageapp.data.model.toDomain
import com.loptech.messageapp.domain.model.Message
import com.loptech.messageapp.domain.model.SendingMessage
import com.loptech.messageapp.domain.model.toDomain
import javax.inject.Inject

class MessageRepository @Inject constructor(
    private val messageDao: MessageDao,
    private val sendingMessageDao: SendingMessageDao
) {
    suspend fun getMessageFromDatabase():List<Message>{
        val response = messageDao.getAllMessages()
        return response.map { it.toDomain() }
    }

    suspend fun getSendingMessageFromDatabase():List<SendingMessage>{
        val response = sendingMessageDao.getAllMessages()
        return response.map { it.toDomain() }
    }

    suspend fun insertMessage(message:MessageEntity){
        messageDao.insertMessage(message)
    }
    suspend fun insertSendingMessage(message:SendingMessageEntity){
        sendingMessageDao.insertMessage(message)
    }
}
package com.loptech.messageapp.domain.SendingMessageUseCases

import com.loptech.messageapp.data.MessageRepository
import com.loptech.messageapp.data.database.entities.toDatabase
import com.loptech.messageapp.domain.model.Message
import javax.inject.Inject

class SaveSendingMessageUseCase @Inject constructor(
    private val repository: MessageRepository
) {
    suspend operator fun invoke(message: Message){
        return repository.insertMessage(message.toDatabase())
    }
}
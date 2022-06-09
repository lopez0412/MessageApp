package com.loptech.messageapp.domain.MessageUseCases

import com.loptech.messageapp.data.MessageRepository
import com.loptech.messageapp.data.database.entities.toDatabase
import com.loptech.messageapp.domain.model.Message
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val repository: MessageRepository
) {
    suspend operator fun invoke(message: Message){
        repository.insertMessage(message.toDatabase())
    }
}
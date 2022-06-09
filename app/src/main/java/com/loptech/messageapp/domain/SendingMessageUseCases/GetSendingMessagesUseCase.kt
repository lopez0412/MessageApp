package com.loptech.messageapp.domain.SendingMessageUseCases

import com.loptech.messageapp.data.MessageRepository
import com.loptech.messageapp.domain.model.Message
import com.loptech.messageapp.domain.model.SendingMessage
import javax.inject.Inject

class GetSendingMessagesUseCase @Inject constructor(
    private val repository: MessageRepository
) {
    suspend operator fun invoke():List<SendingMessage>{
        return repository.getSendingMessageFromDatabase()
    }
}
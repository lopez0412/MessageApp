package com.loptech.messageapp.domain.MessageUseCases

import com.loptech.messageapp.data.MessageRepository
import com.loptech.messageapp.domain.model.Message
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(
    private val repository: MessageRepository
) {
    suspend operator fun invoke():List<Message>{
        return repository.getMessageFromDatabase()
    }
}
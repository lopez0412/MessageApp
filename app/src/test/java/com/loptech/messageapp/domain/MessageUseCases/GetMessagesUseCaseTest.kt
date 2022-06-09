package com.loptech.messageapp.domain.MessageUseCases


import com.loptech.messageapp.data.MessageRepository
import com.loptech.messageapp.domain.model.Message
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


internal class GetMessagesUseCaseTest {
    @RelaxedMockK
    private lateinit var repository : MessageRepository

    lateinit var getMessagesUseCase: GetMessagesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getMessagesUseCase = GetMessagesUseCase(repository)
    }

    @Test
    fun `When Database Return Values` () = runBlocking {
        //Given
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val formatted = current.format(formatter)
        val myList = listOf(Message(formatted,"56556456","Welcome to the jungle!"))
        coEvery { repository.getMessageFromDatabase() } returns myList

        //When
        val response = getMessagesUseCase()

        //Then
        coVerify (exactly = 1){
            repository.getMessageFromDatabase()
        }

        assert(myList == response)
    }

    @Test
    fun `When Database return empty`() = runBlocking {
        //Given
        coEvery { repository.getMessageFromDatabase() } returns emptyList()

        //When
        getMessagesUseCase()

        //Then
        coVerify {
            repository.getMessageFromDatabase()
        }
    }

}
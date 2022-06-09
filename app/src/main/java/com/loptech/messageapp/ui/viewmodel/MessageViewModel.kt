package com.loptech.messageapp.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loptech.messageapp.domain.MessageUseCases.GetMessagesUseCase
import com.loptech.messageapp.domain.MessageUseCases.SendMessageUseCase
import com.loptech.messageapp.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val getMessagesUseCase: GetMessagesUseCase,
    private val sendMessageUseCase: SendMessageUseCase
):ViewModel() {
    val messageModel = MutableLiveData<List<Message>>()

    fun onCreate() {
        viewModelScope.launch {
            val result = getMessagesUseCase()

            if (!result.isNullOrEmpty()) {
                messageModel.postValue(result)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendMessage(to:String, message:String){
        viewModelScope.launch {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
            val formatted = current.format(formatter)
            sendMessageUseCase(Message(formatted,to,message))
        }
    }


}
package com.loptech.messageapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.loptech.messageapp.databinding.ActivityMainBinding
import com.loptech.messageapp.ui.adapters.MessageRecyclerViewAdapter
import com.loptech.messageapp.ui.viewmodel.MessageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  var adapter = MessageRecyclerViewAdapter()
    private lateinit var binding: ActivityMainBinding

    private val messageViewModel:MessageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        messageViewModel.onCreate()

        binding.recyclerMessages.adapter = adapter

        messageViewModel.messageModel.observe(this, Observer { messageList ->
            adapter.setMessageList(messageList)
        })

        binding.btnSend.setOnClickListener {
            var toNumber = binding.toNumber.text.toString()
            var message = binding.messageTxt.text.toString()
            if (toNumber.isEmpty()){
                binding.toNumber.error = "Please fill the number field"
                binding.toNumber.requestFocus()

            }else
            if (message.isEmpty()){
                binding.messageTxt.error = "Please fill the message field"
                binding.messageTxt.requestFocus()

            }else {
                messageViewModel.sendMessage(toNumber, message)
                binding.toNumber.setText("")
                binding.messageTxt.setText("")
                messageViewModel.onCreate()
            }
        }
    }



}
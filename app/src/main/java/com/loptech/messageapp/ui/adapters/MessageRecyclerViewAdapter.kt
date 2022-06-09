package com.loptech.messageapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.loptech.messageapp.databinding.ItemBinding
import com.loptech.messageapp.domain.model.Message
import com.loptech.messageapp.ui.view.MainActivity

class MessageRecyclerViewAdapter() : RecyclerView.Adapter<MainViewHolder>() {
    var messages = mutableListOf<Message>()
    lateinit var cont : Context
    fun setMessageList(messages: List<Message>) {
        this.messages = messages.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val message = messages[position]
        holder.binding.txtToNumber.text = message.to
        holder.binding.txtMessage.text = message.message
        holder.binding.txtDate.text = message.datetime
    }
    override fun getItemCount(): Int {
        return messages.size
    }
}
class MainViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
}
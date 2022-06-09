package com.loptech.messageapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.loptech.messageapp.data.database.dao.MessageDao
import com.loptech.messageapp.data.database.dao.SendingMessageDao
import com.loptech.messageapp.data.database.entities.MessageEntity
import com.loptech.messageapp.data.database.entities.SendingMessageEntity

@Database(
    entities = [
        MessageEntity::class,
        SendingMessageEntity::class], version = 1
)
abstract class MessageDatabase : RoomDatabase() {
    abstract fun getMessageDao():MessageDao
    abstract fun getSendingMessageDao():SendingMessageDao
}
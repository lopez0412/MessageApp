package com.loptech.messageapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.loptech.messageapp.domain.model.Message

@Entity(tableName = "message_table")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") val id: Int = 0,
    @ColumnInfo(name = "DateTime") val datetime:String,
    @ColumnInfo(name="To") val to:String,
    @ColumnInfo(name="message") val message:String
)

fun Message.toDatabase() = MessageEntity(datetime = datetime, to = to, message = message)
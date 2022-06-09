package com.loptech.messageapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.loptech.messageapp.domain.model.SendingMessage

@Entity(
    tableName = "sending_message_table",
    foreignKeys = [ForeignKey(
        entity = MessageEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("messageId")
    )]
)
data class SendingMessageEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "messageId") val messageId: Int,
    @ColumnInfo(name = "DateTime") val datetime: String,
    @ColumnInfo(name = "confirmationCode") val confirmationCode: String
)

fun SendingMessage.toDatabase() = SendingMessageEntity(messageId=messageId, datetime = datetime, confirmationCode = confirmationCode)
package com.loptech.messageapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.loptech.messageapp.data.database.entities.MessageEntity
import com.loptech.messageapp.data.database.entities.SendingMessageEntity

@Dao
interface SendingMessageDao {
    @Query("Select * From sending_message_table order by id Desc")
    suspend fun getAllMessages():List<SendingMessageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: SendingMessageEntity)

    @Query("Delete from sending_message_table Where id = :idDelete")
    suspend fun deleteMessage(idDelete:Int)
}
package com.loptech.messageapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.loptech.messageapp.data.database.entities.MessageEntity

@Dao
interface MessageDao {
    @Query("Select * From message_table order by id Desc")
    suspend fun getAllMessages():List<MessageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message:MessageEntity)

    @Query("Delete from message_table Where id = :idDelete")
    suspend fun deleteMessage(idDelete:Int)
}
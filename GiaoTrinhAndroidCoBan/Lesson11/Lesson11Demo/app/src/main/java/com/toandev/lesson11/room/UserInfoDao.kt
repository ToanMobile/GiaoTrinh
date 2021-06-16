package com.toandev.lesson11.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserInfoDao {

    @Query("DELETE FROM userinfo")
    suspend fun deleteAllUser()

}
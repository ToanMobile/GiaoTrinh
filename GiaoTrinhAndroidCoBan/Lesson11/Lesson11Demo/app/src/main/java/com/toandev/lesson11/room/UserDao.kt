package com.toandev.lesson11.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM userinfo WHERE userName = :userName")
    suspend fun getUser(userName: String): User

    @Query("SELECT * FROM userinfo")
    suspend fun getListUser(): List<User>

    @Query("DELETE FROM userinfo where userName= :userName")
    suspend fun deleteUser(userName: String)

}
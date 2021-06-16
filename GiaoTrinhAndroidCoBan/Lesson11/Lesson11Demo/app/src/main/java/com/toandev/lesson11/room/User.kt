package com.toandev.lesson11.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserInfo")
data class User(
    //@ColumnInfo(name = "user_name")
    val userName: String,
    val info: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0;
}

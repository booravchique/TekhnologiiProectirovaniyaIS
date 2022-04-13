package com.example.bus.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoginInfo")
data class loginInfo(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "Login")
    var login: String,

    @ColumnInfo(name = "Password")
    var password: String,

    )

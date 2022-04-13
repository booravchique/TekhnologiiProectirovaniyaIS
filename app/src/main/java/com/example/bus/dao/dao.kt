package com.example.bus.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bus.entity.loginInfo

@Dao
interface dao {

    @Query("SELECT * FROM LoginInfo")
    fun getAllData(): LiveData<List<loginInfo>>

    @Query("SELECT * FROM LoginInfo WHERE login = login")
    fun getByLogin(login: String): loginInfo?

    @Insert
    suspend fun insert(item: List<loginInfo>)

    @Update
    suspend fun update(item: loginInfo)

    @Delete
    suspend fun delete(item: loginInfo)
}
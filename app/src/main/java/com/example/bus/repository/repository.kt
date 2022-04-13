package com.example.bus.repository

import androidx.lifecycle.LiveData
import com.example.bus.dao.dao
import com.example.bus.entity.loginInfo

class repository(private val dao: dao) {
    val readAllData: LiveData<List<loginInfo>> = dao.getAllData()

    suspend fun addInfo(item: List<loginInfo>) {
        dao.insert(item)
    }

    suspend fun updateInfo(item: loginInfo) {
        dao.update(item)
    }

    suspend fun deleteInfo(item: loginInfo) {
        dao.delete(item)
    }


}
package com.example.bus.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bus.dao.dao
import com.example.bus.entity.loginInfo

@Database(entities = [loginInfo::class], version = 1, exportSchema = false)
abstract class database: RoomDatabase(){
    abstract fun dao(): dao

    companion object {

        @Volatile
        private var INSTANCE: database? = null

        fun getInstance(context: Context): database {
            synchronized(this) {
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    database::class.java,
                    "database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
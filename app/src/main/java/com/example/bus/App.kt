package com.example.bus

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase



class App: Application() {


    private lateinit var database: RoomDatabase
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, RoomDatabase::class.java, "database")
            .build()
    }

    fun getInst() = this
    fun getDatabase()= database


}
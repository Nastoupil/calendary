package com.example.calendary

import android.content.Context
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase


class databaze {
    @androidx.room.Database(entities = [entity::class], version = 1)
    abstract class AppDb : RoomDatabase() {
        abstract fun noteDao(): databazeinterface

        companion object {
            private var instance: AppDb? = null
            fun getDatabase(context: Context): AppDb {
                if (instance != null) {
                    return instance as AppDb
                } else {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDb::class.java,
                        "events"
                    ).allowMainThreadQueries().build()
                    return instance as AppDb
                }
            }
        }
    }



}

package com.example.rng.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rng.data.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

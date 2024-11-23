package com.example.rng.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rng.data.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE email = :email AND password = :password")
    suspend fun loginUser(email: String, password: String): User?

    @Query("SELECT * FROM user_table WHERE id = :id")
    fun getUserById(id: String): User?
}

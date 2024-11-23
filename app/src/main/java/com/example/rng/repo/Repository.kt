package com.example.rng.repo


import android.content.SharedPreferences
import com.example.rng.data.User
import com.example.rng.db.UserDao
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val sharedPreferences: SharedPreferences
) {

    suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        val user = userDao.loginUser(email, password)
        if (user != null) {
            // Save the logged-in user's ID to SharedPreferences
            sharedPreferences.edit().putString("current_user_id", user.id.toString()).apply()
        }
        return user
    }

    fun getCurrentUser(): User? {
        val userId = sharedPreferences.getString("current_user_id", null)
        return userId?.let { userDao.getUserById(it) }
    }

    fun logoutUser() {
        sharedPreferences.edit().remove("current_user_id").apply()
    }
}


package com.example.ordereasy.data

import java.util.Locale

class User(val username: String, val password: String) {
    companion object {
        private val users = listOf(
            User("user1", "password1"),
            User("user2", "password2")
        )

        fun validate(username: String, password: String): Boolean {
            return users.any { it.username == username && it.password.toLowerCase(Locale.ROOT).equals(password.toLowerCase(
                Locale.ROOT)) }
        }
    }
}

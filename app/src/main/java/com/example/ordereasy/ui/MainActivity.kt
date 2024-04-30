package com.example.ordereasy

import com.example.ordereasy.data.User
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            if (validate()) {
                // Validación exitosa - Inicia una nueva actividad (modifica según tu app)
                val intent = Intent(this, MenuActivity2::class.java)
                startActivity(intent)
            } else {
                // Validación fallida - Muestra un mensaje de error
                Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validate(): Boolean {
        val usernameInput = username.text.toString().trim()
        val passwordInput = password.text.toString().trim()

        // Busca el usuario en la lista usando "find"
        val user = users.find { it.username == usernameInput && it.password == passwordInput }

        return user != null // Devuelve true si el usuario existe, false en caso contrario
    }

    companion object {
        // Lista de usuarios de ejemplo (reemplaza con tu mecanismo de autenticación real)
        private val users = listOf(
            User("Sara1", "1234"),
            User("Lucho2", "1234")
        )
    }
}
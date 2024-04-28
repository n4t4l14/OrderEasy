package com.example.ordereasy

// Importar las bibliotecas necesarias de Android
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ordereasy.databinding.ActivityMainBinding

// Declarar la clase MainActivity, que extiende de AppCompatActivity
class MainActivity : AppCompatActivity() {

    // Declarar una variable lateinit para el botón de registro
    private lateinit var btnregistrar: Button

    // Declarar variables lateinit para el data binding y el helper de base de datos
    lateinit var binding: ActivityMainBinding
    lateinit var orderEasyDBHelper: miSQLiteHelper

    // Sobrescribir el método onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilitar la visualización de borde a borde (edge-to-edge)
        enableEdgeToEdge()

        // Establecer la vista del contenido utilizando data binding
        setContentView(R.layout.activity_main)

        // Aplicar los insets al diseño principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Encontrar el botón de inicio de sesión por su ID
        val button = findViewById<Button>(R.id.loginButton)

        // Establecer un clic para el botón de inicio de sesión
        button.setOnClickListener{
            // Crear un intento para navegar a MenuActivity2
            val intent = Intent(this, MenuActivity2::class.java)
            // Iniciar la actividad
            startActivity(intent)
        }

        // Encontrar el botón de registro por su ID
        val butto = findViewById<Button>(R.id.sinupButton)

        // Establecer un clic para el botón de registro
        butto.setOnClickListener{
            // Crear un intento para navegar a la actividad de registro (signup)
            val intent = Intent(this, signup::class.java)
            // Iniciar la actividad
            startActivity(intent)
        }
    }
}


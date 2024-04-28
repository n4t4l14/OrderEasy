package com.example.ordereasy.ui.profile

// Importar las bibliotecas necesarias de Android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ordereasy.R
import com.example.ordereasy.databinding.FragmentProfileBinding
import com.example.ordereasy.miSQLiteHelper

// Declarar la clase ProfileFragment que extiende de Fragment
class ProfileFragment : Fragment() {

    // Variables privadas
    private var _binding: FragmentProfileBinding? = null
    private lateinit var orderEasyDBHelper: miSQLiteHelper

    // Esta propiedad solo es válida entre onCreateView y onDestroyView
    private val binding get() = _binding!!

    // Sobrescribir el método onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inicializar el helper de base de datos SQLite
        orderEasyDBHelper = miSQLiteHelper(requireContext())

        // Configurar el botón de edición de usuario
        binding.btnEditUser.setOnClickListener {
            // Obtener los datos ingresados por el usuario
            val nombre = binding.textPersonName.text.toString()
            val apellido = binding.textPersonLastName.text.toString()
            val usuario = binding.textUserName.text.toString()
            val telefono = binding.textPhone.text.toString()
            val correo = binding.textEmail.text.toString()
            val edad = binding.textAge.text.toString()

            // Verificar que todos los campos estén llenos
            if (nombre.isNotBlank() &&
                apellido.isNotBlank() &&
                usuario.isNotBlank() &&
                telefono.isNotBlank() &&
                correo.isNotBlank() &&
                edad.isNotBlank()
            ) {
                // Insertar los datos en la base de datos SQLite
                orderEasyDBHelper.anadirDato(nombre, apellido, usuario, telefono, correo, edad)

                // Limpiar los campos de texto
                binding.textPersonName.text.clear()
                binding.textPersonLastName.text.clear()
                binding.textUserName.text.clear()
                binding.textPhone.text.clear()
                binding.textEmail.text.clear()
                binding.textAge.text.clear()

                // Mostrar un mensaje de éxito
                Toast.makeText(requireContext(), "Guardado", Toast.LENGTH_SHORT).show()
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                Toast.makeText(requireContext(), "No se ha podido guardar", Toast.LENGTH_LONG).show()
            }
        }

        return root
    }

    // Sobrescribir el método onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el botón de edición de usuario para navegar a la pantalla de edición de perfil
        binding.btnEditUser.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileEditFragment)
        }
    }

    // Sobrescribir el método onDestroyView para evitar fugas de memoria
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

// Función de extensión para limpiar un campo de texto
private fun CharSequence.clear() {
    TODO("Not yet implemented")
}



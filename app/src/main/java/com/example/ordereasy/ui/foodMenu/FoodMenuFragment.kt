package com.example.ordereasy.ui.foodMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ordereasy.databinding.FragmentFoodMenuBinding

class FoodMenuFragment : Fragment() {

    private var _binding: FragmentFoodMenuBinding? = null

    // Esta propiedad solo es válida entre onCreateView y
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Crear una instancia del ViewModel asociado al fragmento
        val foodMenuViewModel = ViewModelProvider(this).get(FoodMenuViewModel::class.java)

        // Inflar y vincular el diseño del fragmento utilizando ViewBinding
        _binding = FragmentFoodMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Devolver la vista raíz del fragmento
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Liberar la referencia al binding cuando se destruye la vista
        _binding = null
    }
}

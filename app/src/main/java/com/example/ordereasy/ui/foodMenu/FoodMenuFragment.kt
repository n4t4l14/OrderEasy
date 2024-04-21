package com.example.ordereasy.ui.foodMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ordereasy.R
import com.example.ordereasy.databinding.FragmentFoodMenuBinding

class FoodMenuFragment : Fragment() {

    private var _binding: FragmentFoodMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val foodMenuViewModel = ViewModelProvider(this).get(FoodMenuViewModel::class.java)

        _binding = FragmentFoodMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnImgAjiaco.setImageResource(R.mipmap.ajiaco)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
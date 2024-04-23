package com.example.ordereasy.ui.profile

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ordereasy.R
import com.example.ordereasy.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private lateinit var db: SQLiteDatabase

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Cargamos la imagen de perfil
        binding.avatarProfile.setImageResource(R.mipmap.profile_image)

        binding.textPersonName.text = "Juanita"
        binding.textPersonLastName .text = "Perez"
        binding.textUserName.text = "jperez"
        binding.textPhone.text = "3192152284"
        binding.textEmail.text = "jperez@gmail.com"
        binding.textAge.text = "30"

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEditUser.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileEditFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
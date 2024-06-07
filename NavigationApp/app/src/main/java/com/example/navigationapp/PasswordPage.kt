package com.example.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigationapp.databinding.FragmentPasswordPageBinding

class PasswordPage : Fragment() {
    private lateinit var binding : FragmentPasswordPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasswordPageBinding.inflate(layoutInflater)
        val user_name = requireArguments().getString("name_data")
        binding.apply {
            name.text = user_name.toString()
            submit.setOnClickListener { passwordChecker(it) }
        }
        return binding.root
    }
    private fun passwordChecker(it : View) = if(binding.password.text.toString() == (binding.confirm.text.toString())){
        it.findNavController().navigate(R.id.action_passwordPage_to_greetingPage)
    }else{
        Toaster.toast(binding.root.context, "Mismatch Password")
    }
}
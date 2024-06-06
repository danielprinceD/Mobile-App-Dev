package com.example.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigationapp.databinding.FragmentGreetingPageBinding

class GreetingPage : Fragment() {
    private lateinit var binding : FragmentGreetingPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGreetingPageBinding.inflate(layoutInflater)
        binding.apply { ok.setOnClickListener{it.findNavController().navigate(R.id.action_greetingPage_to_homePage)} }
        return binding.root
    }

}
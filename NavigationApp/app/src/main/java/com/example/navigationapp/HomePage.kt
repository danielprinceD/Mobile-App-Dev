package com.example.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigationapp.databinding.ActivityMainBinding
import com.example.navigationapp.databinding.FragmentHomePageBinding

class HomePage : Fragment() {
   private lateinit var binding: FragmentHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(layoutInflater)
        binding.apply {

        next.setOnClickListener {
                if(name.text.isNotEmpty()){
                    it.findNavController().navigate(R.id.action_homePage_to_passwordPage)
                }else
                {
                    Toaster.toast(root.context,"Fill the Input Data")
                }
            }
        }
        return binding.root
    }

}
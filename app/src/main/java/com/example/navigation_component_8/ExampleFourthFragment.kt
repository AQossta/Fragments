package com.example.navigation_component_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation_component_8.databinding.FragmentExampleFourthBinding
import com.example.navigation_component_8.databinding.FragmentExampleSecondBinding

class ExampleFourthFragment : Fragment() {

    private lateinit var binding: FragmentExampleFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExampleFourthBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_exampleFourthFragment_to_exampleFifthFragment)
        }
    }
}
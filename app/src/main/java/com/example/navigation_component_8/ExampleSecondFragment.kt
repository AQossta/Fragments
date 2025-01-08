package com.example.navigation_component_8

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.navigation_component_8.data.Meme
import com.example.navigation_component_8.data.RetrofitService
import com.example.navigation_component_8.databinding.FragmentExampleSecondBinding
import kotlinx.coroutines.launch

class ExampleSecondFragment : Fragment() {

    private lateinit var binding: FragmentExampleSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExampleSecondBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_exampleSecondFragment_to_exampleThirdFragment)
        }
        lifecycleScope.launch {
            try{
                val pesponse = RetrofitService.apiServiceMemes.getMemes()
                val listMemes:List<Meme> = pesponse.data.memes
                Log.d("AAA", listMemes.toString())
                val adapter = ExampleRecyclerAdapter()
                binding.rcViewMemes.adapter = adapter
                adapter.submitList(listMemes)
            } catch (e:Exception){

            }
        }
    }

}


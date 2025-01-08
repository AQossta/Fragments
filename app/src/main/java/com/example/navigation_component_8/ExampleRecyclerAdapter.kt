package com.example.navigation_component_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navigation_component_8.data.Meme
import com.example.navigation_component_8.databinding.ExampleAdapterBinding

class ExampleRecyclerAdapter(): RecyclerView.Adapter<ExampleRecyclerAdapter.ExampleViewHolder>() {

    private val adapterList = mutableListOf<Meme>()

    inner class ExampleViewHolder(private val binding: ExampleAdapterBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(memeItem: Meme){
            binding.tvProductTitle.text = memeItem.name
            binding.tvProductPrice.text = memeItem.url
            Glide.with(binding.imageView2.context)
                .load(memeItem.url)
                .into(binding.imageView2)
        }
    }

    fun submitList(list: List<Meme>){
        adapterList.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExampleRecyclerAdapter.ExampleViewHolder {
        return ExampleViewHolder(
            ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ExampleRecyclerAdapter.ExampleViewHolder, position: Int) {
        holder.onBind(adapterList[position])
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }
}
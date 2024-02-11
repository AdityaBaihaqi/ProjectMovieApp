package com.baihaqi.exstream

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baihaqi.exstream.data.response.ResultsItem
import com.baihaqi.exstream.databinding.ItemCharacterBinding
import com.bumptech.glide.Glide

class MainAdapter(private val listCharacters: List<ResultsItem>, private val context: Context) : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    class ListViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: ResultsItem, context: Context) {
            with(binding) {
                icTitle.text = character.title
                // Load gambar poster menggunakan Glide
                Glide.with(itemView)
                    .load("https://image.tmdb.org/t/p/w500${character.posterPath}")
                    .into(icImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listCharacters.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listCharacters[position], context)
    }
}
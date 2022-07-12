package com.example.tworecyclerview.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tworecyclerview.databinding.ClothesItemBinding
import com.example.tworecyclerview.models.ClothesItem

class ItemsAdapter() : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    private val clothesList = mutableListOf<ClothesItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder =
        ItemsViewHolder(
            ClothesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = clothesList.size

    inner class ItemsViewHolder(private val binding: ClothesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var clothesItems: ClothesItem

        @SuppressLint("SetTextI18n")
        fun bind() {
            clothesItems = clothesList[adapterPosition]
            binding.apply {
                ivItemPhoto.setImageResource(clothesItems.photo)
                tvItemDescription.text = clothesItems.description
                tvItemPrice.text = clothesItems.price.toString() + '$'
            }
        }
    }

    fun setItemsData(data: List<ClothesItem>) {
        this.clothesList.clear()
        this.clothesList.addAll(data)
        notifyDataSetChanged()
    }
}
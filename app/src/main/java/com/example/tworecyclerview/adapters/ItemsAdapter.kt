package com.example.tworecyclerview.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tworecyclerview.databinding.ClothesItemBinding
import com.example.tworecyclerview.models.ClothesItem
import com.example.tworecyclerview.utils.ClothesUtil

class ItemsAdapter() : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    private var clothesList = mutableListOf<ClothesItem>()


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
        val diffUtil = ClothesUtil(clothesList, data)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        clothesList = data as MutableList<ClothesItem>
        diffResults.dispatchUpdatesTo(this)
    }
}
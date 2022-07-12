package com.example.tworecyclerview.adapters

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tworecyclerview.R
import com.example.tworecyclerview.databinding.CategoryItemBinding
import com.example.tworecyclerview.enums.CategoryEnums
import com.example.tworecyclerview.models.Category
import com.example.tworecyclerview.models.ClothesItem
import java.util.*

class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categoryItemsList = mutableListOf<Category>()

    var onCategoryClick: ((Category) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = categoryItemsList[position]
        holder.itemView.setOnClickListener {
            onCategoryClick?.invoke(item)
            holder.itemView.setBackgroundResource(R.drawable.category_select)
        }
        holder.bind()

    }

    override fun getItemCount() = categoryItemsList.size

    inner class CategoryViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var categories: Category

        fun bind() {
            categories = categoryItemsList[adapterPosition]
            binding.apply {
                categoryIcon.setImageResource(categories.icon)
                categoryName.text = categories.categoryName
            }

        }

    }

    fun setCategoryData(data: List<Category>) {
        this.categoryItemsList.clear()
        this.categoryItemsList.addAll(data)
        notifyDataSetChanged()
    }

}

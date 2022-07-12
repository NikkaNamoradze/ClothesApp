package com.example.tworecyclerview.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.tworecyclerview.models.Category

class CategoryUtil(
    private val oldList: List<Category>,
    private val newList: List<Category>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size


    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].categoryName == newList[newItemPosition].categoryName

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].icon != newList[newItemPosition].icon -> {
                false
            }
            oldList[oldItemPosition].categoryName != newList[newItemPosition].categoryName -> {
                false
            }
            else -> true
        }
    }
}
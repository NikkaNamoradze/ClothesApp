package com.example.tworecyclerview.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.tworecyclerview.models.ClothesItem

class ClothesUtil(
    private val oldList: List<ClothesItem>,
    private val newList: List<ClothesItem>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].photo == newList[newItemPosition].photo

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].photo != newList[newItemPosition].photo -> {
                false
            }
            oldList[oldItemPosition].category != newList[newItemPosition].category -> {
                false
            }
            oldList[oldItemPosition].description != newList[newItemPosition].description -> {
                false
            }
            oldList[oldItemPosition].price != newList[newItemPosition].price -> {
                false
            }
            else -> true
        }
    }
}
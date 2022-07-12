package com.example.tworecyclerview.lists

import com.example.tworecyclerview.R
import com.example.tworecyclerview.enums.CategoryEnums
import com.example.tworecyclerview.models.Category
import com.example.tworecyclerview.models.ClothesItem

val categoryList = listOf(
    Category(R.drawable.ic_baseline_all_inclusive_24, CategoryEnums.All.name),
    Category(R.drawable.party_icon, CategoryEnums.Party.name),
    Category(R.drawable.camping_icon, CategoryEnums.Camping.name),
    Category(R.drawable.prom_icon, CategoryEnums.Prom.name),
    Category(R.drawable.wedding_icon, CategoryEnums.Wedding.name),
)
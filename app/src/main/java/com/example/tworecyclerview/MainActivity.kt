package com.example.tworecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tworecyclerview.adapters.CategoryAdapter
import com.example.tworecyclerview.adapters.ItemsAdapter
import com.example.tworecyclerview.databinding.ActivityMainBinding
import com.example.tworecyclerview.enums.CategoryEnums
import com.example.tworecyclerview.models.Category
import com.example.tworecyclerview.models.ClothesItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var clothesAdapter: ItemsAdapter
    private var categoryList = mutableListOf<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setCategories()

        setCategoryRecycler(categoryList)
        setClothesRecycler(productList)
    }

    private fun setCategoryRecycler(data: MutableList<Category>) {
        categoryAdapter = CategoryAdapter()
        binding.categoryRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
        categoryAdapter.setCategoryData(data)

        categoryAdapter.onCategoryClick = {
            when (it.categoryName) {
                CategoryEnums.All.name -> {
                    setClothesRecycler(productList)
                }
                CategoryEnums.Party.name -> {
                    val partyClothes = mutableListOf<ClothesItem>()
                    productList.forEach { clothes ->
                        if (clothes.category == "Party") {
                            partyClothes.addAll(listOf(clothes))
                            setClothesRecycler(partyClothes)
                        }
                    }
                }
                CategoryEnums.Camping.name -> {
                    val campingClothes = mutableListOf<ClothesItem>()
                    productList.forEach { clothes ->
                        if (clothes.category == "Camping") {
                            campingClothes.addAll(listOf(clothes))
                            setClothesRecycler(campingClothes)
                        }
                    }
                }
                CategoryEnums.Prom.name -> {
                    val promClothes = mutableListOf<ClothesItem>()
                    productList.forEach { clothes ->
                        if (clothes.category == "Prom") {
                            promClothes.addAll(listOf(clothes))
                            setClothesRecycler(promClothes)
                        }
                    }
                }
                CategoryEnums.Wedding.name -> {
                    val weddingClothes = mutableListOf<ClothesItem>()
                    productList.forEach { clothes ->
                        if (clothes.category == "Wedding") {
                            weddingClothes.addAll(listOf(clothes))
                            setClothesRecycler(weddingClothes)
                        }
                    }
                }
            }
        }
    }

    private fun setClothesRecycler(data: List<ClothesItem>) {
        clothesAdapter = ItemsAdapter()
        binding.itemsRecycler.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = clothesAdapter
        }
        clothesAdapter.setItemsData(data)
    }

    private fun setCategories() {
        //რადგან წინასწარ იყო გაწერილი კატეგორიები ვიფიქრე რომ მიუთეიბლს არ გავაკეთებდი მაგრამ
        //თუ დამჭირდებოდა რაიმე სხვა კატეგორიის დატამტება პროცესში მაგიტომ ვაკეთებ მიუთეიბლს

        val allCategory = Category(R.drawable.ic_baseline_all_inclusive_24, CategoryEnums.All.name)
        val partyCategory = Category(R.drawable.party_icon, CategoryEnums.Party.name)
        val campingCategory = Category(R.drawable.camping_icon, CategoryEnums.Camping.name)
        val promCategory = Category(R.drawable.prom_icon, CategoryEnums.Prom.name)
        val weddingCategory = Category(R.drawable.wedding_icon, CategoryEnums.Wedding.name)
        categoryList.add(allCategory)
        categoryList.add(partyCategory)
        categoryList.add(campingCategory)
        categoryList.add(promCategory)
        categoryList.add(weddingCategory)

    }

}
package com.kaushik.foodapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var adapter2: RecyclerView.Adapter<*>
    private lateinit var adapter3: RecyclerView.Adapter<*>
    private lateinit var recyclerViewRestaurantList: RecyclerView
    private lateinit var recyclerViewCategoryList: RecyclerView
    private lateinit var recyclerViewPopularList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewCategory()
        recyclerViewPopular()
        recyclerViewRestaurant()
    }

    private fun recyclerViewCategory() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCategoryList = findViewById(R.id.recyclerView)
        recyclerViewCategoryList.layoutManager = linearLayoutManager

        val category = ArrayList<CategoryDomain>()
        category.add(CategoryDomain("Pizza", "cat_1"))
        category.add(CategoryDomain("Burger", "cat_2"))
        category.add(CategoryDomain("HotDog", "cat_3"))
        category.add(CategoryDomain("Drink", "cat_4"))
        category.add(CategoryDomain("Chicken", "cat_5"))

        adapter = CategoryAdapter(category)
        recyclerViewCategoryList.adapter = adapter
    }

    private fun recyclerViewPopular() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPopularList = findViewById(R.id.recyclerView2)
        recyclerViewPopularList.layoutManager = linearLayoutManager

        val foodList = ArrayList<FoodDomain>()
        foodList.add(FoodDomain("Pepperoni pizza", "pop_1", "slices pepperoni,mozzerella cheese,fresh oregano, ground black pepper,pizza sauce", 499.00))
        foodList.add(FoodDomain("Cheese Burger", "pop_2", "beef, Gouda Cheese, Special Sauce, Lettuce, Tomato", 279.00))
        foodList.add(FoodDomain("Veggie Pizza", "pop_3", "olive oil, Vegetable oil,pitted kalamata, cherry tomato, fresh oregano, basil", 499.00))
        foodList.add(FoodDomain("Chicken Wings", "pop_4", "olive oil, barbecue sauce, honey mustard, paprika, cayenne pepper, soy sauce, honey", 359.00))
        foodList.add(FoodDomain("Veg Momos", "pop_5", "Veggies, Onion, Garlic, Soy sauce, Sesame oil, Fresh cilantro, Green chilies, Dip:Mayonnaise/Salsa", 129.00))
        foodList.add(FoodDomain("Chicken Momos", "pop_6", "Ground Chicken, Onion, Garlic, Soy sauce, Sesame oil, Fresh cilantro, Green chilies, Dip:Mayonnaise/Salsa", 149.00))

        adapter2 = PopularAdapter(foodList)
        recyclerViewPopularList.adapter = adapter2
    }

    private fun recyclerViewRestaurant() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewRestaurantList = findViewById(R.id.recyclerView3)
        recyclerViewRestaurantList.layoutManager = linearLayoutManager

        val restaurantList = ArrayList<RestaurantDomain>()
        restaurantList.add(RestaurantDomain("Dominos", "res_1"))
        restaurantList.add(RestaurantDomain("Burger King", "res_2"))
        restaurantList.add(RestaurantDomain("StarBucks", "res_3"))
        restaurantList.add(RestaurantDomain("Faasos", "res_4"))
        restaurantList.add(RestaurantDomain("McDonald's", "res_5"))
        restaurantList.add(RestaurantDomain("KFC", "res_6"))

        adapter3 = RestaurantAdapter(restaurantList)
        recyclerViewRestaurantList.adapter = adapter3
    }
}

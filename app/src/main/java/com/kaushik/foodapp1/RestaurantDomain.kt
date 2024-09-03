package com.kaushik.foodapp1

class RestaurantDomain(private var title: String, private var pic: String){
    fun getTitle(): String {
        return title
    }

    fun getPic(): String {
        return pic
    }
}
package com.kaushik.foodapp1

class FoodDomain(
    private val title: String,
    private val pic: String,
    private val description: String,
    private val fee: Double,
    private val numberInCart: Int = 0
) {
    fun getTitle(): String {
        return title
    }

    fun getPic(): String {
        return pic
    }

    fun getDescription(): String {
        return description
    }

    fun getFee(): Double {
        return fee
    }

    fun getNumberInCart(): Int {
        return numberInCart
    }
}


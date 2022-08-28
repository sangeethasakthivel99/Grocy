package com.sangeetha.grocy.home.domain.model

data class Product(
    val productId: Int,
    val productName: String,
    val price: String,
    val quantity: Int,
    val weight: String,
    val noOfItems: String,
    val image: String
)
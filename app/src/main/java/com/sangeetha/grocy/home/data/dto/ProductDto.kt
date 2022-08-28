package com.sangeetha.grocy.home.data.dto

import com.sangeetha.grocy.home.domain.model.Product

class ProductDto(
    val productId: Int = 0,
    val productName: String = "",
    val price: String = "",
    val quantity: Int = 0,
    val weight: String = "",
    val noOfItems: String = "",
    val image: String = ""
) {
    companion object Factory {
        fun create(): ProductDto = ProductDto()
    }
}

fun ProductDto.toProductList(): Product {
    return Product(
        this.productId,
        this.productName,
        this.price,
        this.quantity,
        this.weight,
        this.noOfItems,
        this.image
    )
}
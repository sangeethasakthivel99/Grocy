package com.sangeetha.grocy.home.data.dto

import com.sangeetha.grocy.home.domain.model.Categories

data class CategoryDto(
    val categoryId: Int? = 0,
    val categoryImage: String? = "",
    val categoryName: String? = ""
) {
    companion object Factory {
        fun create(): CategoryDto = CategoryDto()
    }
}

fun CategoryDto.toCategories(): Categories {
    return Categories(
        this.categoryId,
        this.categoryImage,
        this.categoryName
    )
}

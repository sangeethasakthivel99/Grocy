package com.sangeetha.grocy.home.domain.repository

import com.sangeetha.grocy.home.data.dto.BannersDto
import com.sangeetha.grocy.home.data.dto.CategoryDto
import com.sangeetha.grocy.home.data.dto.ProductDto

interface HomeRepository {

    suspend fun getBanners(): List<BannersDto>

    suspend fun getCategories(): List<CategoryDto>

    suspend fun getBestSellingProducts(): List<ProductDto>
}
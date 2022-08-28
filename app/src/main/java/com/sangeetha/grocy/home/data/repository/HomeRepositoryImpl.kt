package com.sangeetha.grocy.home.data.repository

import com.sangeetha.grocy.home.data.dto.BannersDto
import com.sangeetha.grocy.home.data.dto.CategoryDto
import com.sangeetha.grocy.home.data.dto.ProductDto
import com.sangeetha.grocy.home.data.remote.HomeDatabase
import com.sangeetha.grocy.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDatabase: HomeDatabase
) : HomeRepository {
    override suspend fun getBanners(): List<BannersDto> {
        return homeDatabase.getBanners()
    }

    override suspend fun getCategories(): List<CategoryDto> {
        return homeDatabase.getCategories()
    }

    override suspend fun getBestSellingProducts(): List<ProductDto> {
        return homeDatabase.getBestSellingProducts()
    }
}
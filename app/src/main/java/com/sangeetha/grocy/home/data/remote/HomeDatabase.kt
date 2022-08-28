package com.sangeetha.grocy.home.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.sangeetha.grocy.home.data.dto.BannersDto
import com.sangeetha.grocy.home.data.dto.CategoryDto
import com.sangeetha.grocy.home.data.dto.ProductDto
import com.sangeetha.grocy.util.Constants.BANNER_COLLECTION
import com.sangeetha.grocy.util.Constants.BEST_SETTING_PRODUCT_COLLECTION
import com.sangeetha.grocy.util.Constants.CATEGORY_COLLECTION
import com.sangeetha.grocy.util.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class HomeDatabase @Inject constructor(fireStore: FirebaseFirestore) {

    private val bannersCollection = fireStore.collection(BANNER_COLLECTION)
    private val categoryCollection = fireStore.collection(CATEGORY_COLLECTION)
    private val bestSellingCollection = fireStore.collection(BEST_SETTING_PRODUCT_COLLECTION)

    suspend fun getBanners(): List<BannersDto> {
        return try {
            bannersCollection.get().await().toObjects(BannersDto::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getCategories(): List<CategoryDto> {
        return try {
            categoryCollection.get().await().toObjects(CategoryDto::class.java)
        } catch (e: Exception) {
            emptyList()
        }

    }

    suspend fun getBestSellingProducts(): Resource<List<ProductDto>> {
        return try {
            Resource.Success(bestSellingCollection.get().await().toObjects(ProductDto::class.java))
        } catch (e: Exception) {
            Resource.Failure(e.localizedMessage ?: "Something went wrong")
        }
    }
}
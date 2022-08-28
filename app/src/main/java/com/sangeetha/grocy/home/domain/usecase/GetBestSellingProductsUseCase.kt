package com.sangeetha.grocy.home.domain.usecase

import com.sangeetha.grocy.home.data.dto.toProductList
import com.sangeetha.grocy.home.domain.model.Product
import com.sangeetha.grocy.home.domain.repository.HomeRepository
import com.sangeetha.grocy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBestSellingProductsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        try {
            val bestSellingProducts = homeRepository.getBestSellingProducts().map {
                it.toProductList()
            }
            emit(Resource.Success(bestSellingProducts))
        } catch (e: IOException) {
            emit(
                Resource.Failure(
                    message = e.localizedMessage
                        ?: "Couldn't reach server. Check your internet connection"
                )
            )
        } catch (e: HttpException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something went wrong"))
        }
    }
}
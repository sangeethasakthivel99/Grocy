package com.sangeetha.grocy.home.domain.usecase

import com.sangeetha.grocy.home.data.dto.toCategories
import com.sangeetha.grocy.home.domain.model.Categories
import com.sangeetha.grocy.home.domain.repository.HomeRepository
import com.sangeetha.grocy.util.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke() = flow {
        emit(Resource.Loading())
        try {
            val categories = homeRepository.getCategories().map {
                it.toCategories()
            }
            emit(Resource.Success(categories))
        } catch (e: HttpException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something went wrong"))
        } catch (e: IOException) {
            emit(
                Resource.Failure(
                    message = e.localizedMessage
                        ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }
}
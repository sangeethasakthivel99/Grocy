package com.sangeetha.grocy.home.domain.usecase

import com.sangeetha.grocy.home.data.dto.toBanners
import com.sangeetha.grocy.home.domain.model.Banners
import com.sangeetha.grocy.home.domain.repository.HomeRepository
import com.sangeetha.grocy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBannersUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    operator fun invoke(): Flow<Resource<List<Banners>>> = flow {
        try {
            emit(Resource.Loading())
            val banners = repository.getBanners().map {
                it.toBanners()
            }
            emit(Resource.Success(banners))
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
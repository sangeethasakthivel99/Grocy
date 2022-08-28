package com.sangeetha.grocy.di

import com.google.firebase.firestore.FirebaseFirestore
import com.sangeetha.grocy.home.data.remote.HomeDatabase
import com.sangeetha.grocy.home.data.repository.HomeRepositoryImpl
import com.sangeetha.grocy.home.domain.repository.HomeRepository
import com.sangeetha.grocy.home.domain.usecase.GetBannersUseCase
import com.sangeetha.grocy.home.domain.usecase.GetBestSellingProductsUseCase
import com.sangeetha.grocy.home.domain.usecase.GetCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFireStoreInstance(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideHomeDatabase(fireStore: FirebaseFirestore): HomeDatabase {
        return HomeDatabase(fireStore)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(homeDatabase: HomeDatabase): HomeRepository {
        return HomeRepositoryImpl(homeDatabase)
    }

    @Provides
    @Singleton
    fun provideBannersUseCase(homeRepository: HomeRepository): GetBannersUseCase {
        return GetBannersUseCase(homeRepository)
    }

    @Provides
    @Singleton
    fun provideCategoriesUseCase(homeRepository: HomeRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(homeRepository)
    }

    @Provides
    @Singleton
    fun provideBestSellingProductsUseCase(homeRepository: HomeRepository): GetBestSellingProductsUseCase {
        return GetBestSellingProductsUseCase(homeRepository)
    }
}
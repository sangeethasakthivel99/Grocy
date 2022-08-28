package com.sangeetha.grocy.home.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sangeetha.grocy.home.domain.usecase.GetBannersUseCase
import com.sangeetha.grocy.home.domain.usecase.GetBestSellingProductsUseCase
import com.sangeetha.grocy.home.domain.usecase.GetCategoriesUseCase
import com.sangeetha.grocy.home.presentation.state.BannersViewState
import com.sangeetha.grocy.home.presentation.state.BestSellingProductViewState
import com.sangeetha.grocy.home.presentation.state.CategoryViewState
import com.sangeetha.grocy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bannersUseCase: GetBannersUseCase,
    private val categoriesUseCase: GetCategoriesUseCase,
    private val bestSellingProductsUseCase: GetBestSellingProductsUseCase
) : ViewModel() {

    private val _bannerState = mutableStateOf(BannersViewState())
    val bannerState = _bannerState

    private val _categoryState = mutableStateOf(CategoryViewState())
    val categoryState = _categoryState

    private val _bestSellingProductsState = mutableStateOf(BestSellingProductViewState())
    val bestSellingProductState = _bestSellingProductsState

    init {
        getBanners()
        getCategories()
        getBestSellingProducts()
    }

    private fun getBanners() {
        viewModelScope.launch {
            bannersUseCase.invoke().collect {
                when (it) {
                    is Resource.Loading -> {
                        _bannerState.value = BannersViewState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _bannerState.value = BannersViewState(banners = it.data ?: emptyList())
                    }

                    is Resource.Failure -> {
                        _bannerState.value =
                            BannersViewState(error = it.message ?: "Something went wrong")
                    }
                }
            }
        }
    }

    private fun getCategories() {
        viewModelScope.launch {
            categoriesUseCase.invoke().collect {
                Log.e("TAG", "getCategories: ${it}")
                when (it) {
                    is Resource.Loading -> {
                        _categoryState.value = CategoryViewState(isLoading = true)
                    }

                    is Resource.Success -> {
                        Log.e("TAG", "getCategories: ${it.data}")
                        _categoryState.value =
                            CategoryViewState(categories = it.data ?: emptyList())
                    }

                    is Resource.Failure -> {
                        _categoryState.value =
                            CategoryViewState(error = it.message ?: "Something went wrong")
                    }
                }
            }
        }
    }

    private fun getBestSellingProducts() {
        viewModelScope.launch {
            bestSellingProductsUseCase.invoke().collect {
                when (it) {
                    is Resource.Loading -> {
                        _bestSellingProductsState.value =
                            BestSellingProductViewState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _bestSellingProductsState.value = BestSellingProductViewState(
                            bestSellingProducts = it.data ?: emptyList()
                        )
                    }

                    is Resource.Failure -> {
                        _bestSellingProductsState.value = BestSellingProductViewState(
                            error = it.message ?: "Something went wrong"
                        )
                    }
                }
            }
        }
    }
}
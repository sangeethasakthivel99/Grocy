package com.sangeetha.grocy.home.presentation.state

import com.sangeetha.grocy.home.domain.model.Product

data class BestSellingProductViewState(
    val isLoading: Boolean = false,
    val bestSellingProducts: List<Product> = emptyList(),
    val error: String = ""
)
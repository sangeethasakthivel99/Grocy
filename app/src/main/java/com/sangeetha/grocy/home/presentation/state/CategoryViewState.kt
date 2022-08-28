package com.sangeetha.grocy.home.presentation.state

import com.sangeetha.grocy.home.domain.model.Categories

data class CategoryViewState(
    val categories: List<Categories> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
package com.sangeetha.grocy.home.presentation.state

import com.sangeetha.grocy.home.domain.model.Banners

data class BannersViewState(
    val isLoading: Boolean = false,
    val banners: List<Banners> = emptyList(),
    val error: String = ""
)
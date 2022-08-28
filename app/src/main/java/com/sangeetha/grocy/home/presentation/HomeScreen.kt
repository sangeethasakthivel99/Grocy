package com.sangeetha.grocy.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sangeetha.grocy.R
import com.sangeetha.grocy.home.presentation.components.Banner
import com.sangeetha.grocy.home.presentation.components.BestSellingProducts
import com.sangeetha.grocy.home.presentation.components.Category
import com.sangeetha.grocy.home.presentation.components.Profile

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val bannerState = viewModel.bannerState.value
    val categoryState = viewModel.categoryState.value
    val bestSellingProductState = viewModel.bestSellingProductState.value

    Surface(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.white)
                )
        ) {
            Profile(greeting = "Hello, welcome", userName = "Amelia Barlow")
            Spacer(modifier = Modifier.height(16.dp))
            if (bannerState.banners.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Banner(banners = bannerState.banners)
                }
            }
            if (categoryState.categories.isNotEmpty()) {
                Category(categoryState.categories)
            }
            if (bestSellingProductState.bestSellingProducts.isNotEmpty()) {
                BestSellingProducts(bestSellingProductState.bestSellingProducts)
            }
        }
    }
}
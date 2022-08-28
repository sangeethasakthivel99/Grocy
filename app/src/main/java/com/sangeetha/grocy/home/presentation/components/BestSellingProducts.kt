package com.sangeetha.grocy.home.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sangeetha.grocy.R
import com.sangeetha.grocy.home.domain.model.Product

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BestSellingProducts(
    products: List<Product>
) {
    CompositionLocalProvider(
        LocalOverScrollConfiguration provides null
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Best Selling \uD83D\uDD25",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.textColor)
                )

                Text(
                    "See all",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.primaryGreen),
                    modifier = Modifier.clickable {

                    }
                )
            }
        }
        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            items(4) {
                ProductListItem(products[it])
            }
        })
    }
}
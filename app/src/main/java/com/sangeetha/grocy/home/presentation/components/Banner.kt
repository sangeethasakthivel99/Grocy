package com.sangeetha.grocy.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.sangeetha.grocy.home.domain.model.Banners

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banner(banners: List<Banners>) {

    val state = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        HorizontalPager(
            count = banners.size,
            state = state,
        ) { currentPage ->
            val painter = rememberImagePainter(data = banners[currentPage].bannerImage)
            Image(
                painter = painter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
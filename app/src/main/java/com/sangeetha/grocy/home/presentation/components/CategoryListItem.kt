package com.sangeetha.grocy.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sangeetha.grocy.R
import com.sangeetha.grocy.home.domain.model.Categories

@Composable
fun CategoryListItem(
    categories: Categories
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .clip(CircleShape)
                .background(
                    color = colorResource(id = R.color.categoryBackground)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberImagePainter(categories.categoryImage ?: ""),
                contentDescription = "",
                Modifier.size(34.dp)
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            categories.categoryName ?: "",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.textColor)
        )
    }
}
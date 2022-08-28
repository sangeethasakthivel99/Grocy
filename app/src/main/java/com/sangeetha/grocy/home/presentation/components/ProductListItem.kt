package com.sangeetha.grocy.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sangeetha.grocy.R
import com.sangeetha.grocy.home.domain.model.Product

@Composable
fun ProductListItem(
    product: Product
) {
    Box(modifier = Modifier
        .padding(12.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(
            color = colorResource(id = R.color.categoryBackground)
        )
        .clickable {
        }) {

        Column(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(product.image),
                contentDescription = "",
                Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                product.productName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = colorResource(id = R.color.textColor),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                "${product.noOfItems} ${product.weight}",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = colorResource(id = R.color.secondaryTextColor),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "$${product.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.textColor),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(
                            42.dp
                        )
                        .width(42.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(colorResource(id = R.color.primaryGreen))
                        .clickable {

                        }) {
                    Icon(Icons.Default.Add, "", tint = Color.White)
                }
            }
        }
    }
}
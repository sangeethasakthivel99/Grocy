package com.sangeetha.grocy.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sangeetha.grocy.R

@Composable
fun Profile(greeting: String, userName: String) {
    Row(
        modifier = Modifier
            .background(
                color = colorResource(id = R.color.categoryBackground)
            )
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "profile"
        )
        Spacer(Modifier.width(12.dp))
        Column {
            Text(
                greeting,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = colorResource(id = R.color.secondaryTextColor)
            )
            Spacer(Modifier.width(5.dp))
            Text(
                userName,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                color = colorResource(id = R.color.textColor),
            )
        }
    }
}
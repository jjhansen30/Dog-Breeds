package com.joshansen.dogbreeds.ui.theme.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

@Composable
fun DogListItem(
    drawableID: Int,
    dogName: String,
    dogDescription: String
) {
    Row(Modifier.height(144.dp)) {
        Image(
            modifier = Modifier.fillMaxHeight(),
            painter = painterResource(drawableID),
            contentDescription = dogName
        )
        Column {
            Text(
                text = dogName,
                fontSize = 16.sp
            )
            Text(text = dogDescription)
        }
    }
}
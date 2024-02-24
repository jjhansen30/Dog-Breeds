package com.joshansen.dogbreeds.ui.theme.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshansen.dogbreeds.R

@Composable
fun DogListItem(
    drawableID: Int,
    dogName: String,
    dogDescription: String,
    nameFontSize: TextUnit = 14.sp,
    descriptionFontSize: TextUnit = 12.sp,
    roundedCorner: Dp = 28.dp,
    startPadding: Dp = 4.dp,
    rowHeight: Dp = 136.dp,
    imageWidth: Dp = 136.dp
) {
    Row(
        Modifier
            .height(rowHeight)
            .clip(shape = RoundedCornerShape(roundedCorner))
            .padding(2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.width(imageWidth),
            painter = painterResource(drawableID),
            contentDescription = dogName,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = dogName,
                fontSize = nameFontSize,
                modifier = Modifier.padding(start = startPadding, top = startPadding),
            )
            Text(
                modifier = Modifier
                    .padding(startPadding)
                    .verticalScroll(rememberScrollState()),
                text = dogDescription,
                fontSize = descriptionFontSize
            )
        }
    }
}

@Preview
@Composable
fun MyPreview() {
    DogListItem(drawableID = R.drawable.d1_lab,
        dogName = "Labrador retriever",
        dogDescription = "Labs are currently the most popular dog in the U.S., and with good reason — this family-friendly companion is good-natured, hard-working and covers all the bases as man’s best friend. \nLabs still work with hunters in retrieving game as they did centuries ago, but they also work as search and rescue, service and show dogs, and make a welcome addition to any home."
    )
}
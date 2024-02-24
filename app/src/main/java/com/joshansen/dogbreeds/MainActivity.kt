package com.joshansen.dogbreeds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joshansen.dogbreeds.ui.theme.common.DogListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogList()
        }
    }
}

@Composable
fun DogList(viewModel: DogsViewModel = viewModel()) {
    LazyColumn(modifier = Modifier.padding(4.dp)) {
        items(viewModel.names.count()) { index ->
            DogListItem(
                drawableID = viewModel.imageIds[index],
                dogName = viewModel.names[index],
                dogDescription =viewModel.desc[index]
            )
        }
    }
}
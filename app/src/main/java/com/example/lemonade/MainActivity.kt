package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}


@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    val images = listOf(
        R.drawable.lemon_tree,
        R.drawable.lemon_squeeze,
        R.drawable.lemon_drink,
        R.drawable.lemon_restart
    )
    val descriptions = listOf(
        R.string.description_lemon_tree,
        R.string.description_lemon_squeeze,
        R.string.description_lemon_drink,
        R.string.description_lemon_restart
    )
    var currentImageIndex by remember { mutableStateOf(0) }
    val clickThreshold = (2..4).random()
    var clickCount by remember { mutableStateOf(0) }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(descriptions[currentImageIndex]), fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        if (currentImageIndex == 1) {
            if (clickCount < clickThreshold) {
                Button(onClick = { clickCount++ }) {
                    Image(
                        painter = painterResource(id = images[currentImageIndex]),
                        contentDescription = null
                    )
                }
            } else {
                currentImageIndex++
                clickCount = 0
            }
        } else {
            Button(onClick = { currentImageIndex = (currentImageIndex + 1) % images.size }) {
                Image(
                    painter = painterResource(id = images[currentImageIndex]),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadeWithButtonAndImage()
}


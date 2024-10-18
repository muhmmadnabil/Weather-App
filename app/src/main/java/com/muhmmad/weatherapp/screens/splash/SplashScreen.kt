package com.muhmmad.weatherapp.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.muhmmad.weatherapp.R
import com.muhmmad.weatherapp.navigation.WeatherScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        val scale = remember {
            androidx.compose.animation.core.Animatable(0f)
        }

        LaunchedEffect(true) {
            scale.animateTo(
                targetValue = 0.9f,
                animationSpec = tween(durationMillis = 800, easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                })
            )

            delay(2000L)

            navController.navigate(WeatherScreens.MainScreen.name)
        }

        Surface(
            modifier = Modifier
                .size(280.dp)
                .align(Alignment.Center)
                .scale(scale.value),
            shape = CircleShape,
            color = Color.White,
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_sun),
                    contentDescription = stringResource(R.string.sun_image),
                    modifier = Modifier.size(95.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    stringResource(R.string.splash_text),
                    color = Color.LightGray
                )
            }
        }
    }
}
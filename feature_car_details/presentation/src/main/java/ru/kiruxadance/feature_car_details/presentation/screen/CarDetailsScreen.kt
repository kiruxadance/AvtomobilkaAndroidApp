package ru.kiruxadance.feature_car_details.presentation.screen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import ru.kiruxadance.feature_car_details.domain.model.Car
import ru.kiruxadance.feature_car_details.presentation.screen.ui.theme.Black900
import java.lang.Float.min


@Composable
fun CarDetailsScreen(
    viewModel: CarDetailsViewModel,
    navController: NavHostController
) {
    val scaffoldState = rememberScaffoldState()
    val lazyListState = rememberLazyListState()

    val scrollOffset: Float = min(
        1f,
        1 - (lazyListState.firstVisibleItemScrollOffset / 600f + lazyListState.firstVisibleItemIndex)
    )

    val size by animateDpAsState(targetValue = max(56.dp, 194.dp * scrollOffset))

    val carDetails = viewModel.carDetails.value
    val carPosts = viewModel.carPosts.value

    Scaffold(scaffoldState = scaffoldState) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            carDetails.data?.let {
                if (size == 56.dp) {
                    TopBar(navController, it.car)
                } else {
                    Header(navController, size = size, item = it.car)
                }
            }
            Column(modifier = Modifier
                .fillMaxSize()) {

                if (carPosts.isLoading) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                if (carPosts.error.isNotBlank()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = carPosts.error)
                    }
                }
                carPosts.data?.let {
                    LazyColumn(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp, size + 16.dp, 16.dp, 16.dp), state = lazyListState) {
                        items(it.posts) {
                            CarPostsItem(item = it)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar(navController: NavHostController, item: Car) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(animationSpec = tween(300)),
        exit = fadeOut(animationSpec = tween(300))
    ) {
        TopAppBar(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primary)
                .height(56.dp),
            ) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Text(
                    text = item.name,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

    }
}


@Composable
fun Header(navController: NavHostController, size: Dp, item: Car) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(size)
    ) {
        val converted = (size.value-56)/(194-56)*(24-20)+20
        val textPadding = 80 - ((size.value - 56)/(194-56)*(64-16) + 16)
        val alphaButton = (size.value-56)/(194-56)*(1-0)+0
        Image(
            painter = rememberAsyncImagePainter(model = item.images[0].url),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(size),
            contentScale = ContentScale.Crop,

            )
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(modifier = Modifier.padding(start = textPadding.dp, bottom = 16.dp),
                text = item.name,
                color = Color.White,
                fontSize = converted.sp,
                fontWeight = FontWeight.Bold)
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Button(modifier = Modifier.size(50.dp).padding(start = 16.dp, top = 16.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White.copy(
                    alpha = alphaButton,
                )),
                onClick = {
                    navController.popBackStack()
                }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "content description")
            }
        }
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Black900),
                        startY = 3 * size.value / 4
                    )
                )
        )
    }
}
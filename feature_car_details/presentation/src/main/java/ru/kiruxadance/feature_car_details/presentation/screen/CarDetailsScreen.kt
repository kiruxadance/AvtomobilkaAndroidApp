package ru.kiruxadance.feature_car_details.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CarDetailsScreen(
    viewModel: CarDetailsViewModel
) {
    val scaffoldState = rememberScaffoldState()

    val carDetails = viewModel.carDetails.value
    val carPosts = viewModel.carPosts.value

    Scaffold(scaffoldState = scaffoldState) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
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
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
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
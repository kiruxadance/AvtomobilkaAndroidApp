package ru.kiruxadance.feature_cars_list.presentation.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.kiruxadance.feature_cars_list.domain.model.Car

@Composable
fun CarsScreen(
    viewModel: CarsViewModel,
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val result = viewModel.carsList.value

    Scaffold(scaffoldState = scaffoldState) {contentPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                if (result.isLoading) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                if (result.error.isNotBlank()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = result.error)
                        Log.d("error: ", result.error)
                    }
                }
                result.data?.let {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(it) {
                            CarItem(modifier = Modifier.fillMaxWidth().clickable {
                                navController.navigate("cars_details/${it.id}")
                            }, item = it)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}


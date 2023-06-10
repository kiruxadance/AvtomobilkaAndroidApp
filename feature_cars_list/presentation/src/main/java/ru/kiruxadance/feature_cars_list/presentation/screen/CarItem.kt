package ru.kiruxadance.feature_cars_list.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ru.kiruxadance.feature_cars_list.domain.model.Car

@Composable
fun CarItem(modifier: Modifier = Modifier,
            item: Car) {
    
    Card(modifier = modifier, elevation = 3.dp, shape = RoundedCornerShape(4.dp)) {
        Column {
            Image(modifier = Modifier.height(194.dp)
                .fillMaxWidth(), painter = rememberAsyncImagePainter(model = item.image), contentDescription = "car image", contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(8.dp))
            Text(modifier = Modifier.padding(16.dp, 0.dp), style = MaterialTheme.typography.h6, text = item.name)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

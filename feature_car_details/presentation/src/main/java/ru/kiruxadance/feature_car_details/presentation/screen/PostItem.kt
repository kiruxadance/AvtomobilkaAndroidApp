package ru.kiruxadance.feature_car_details.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ru.kiruxadance.feature_car_details.domain.model.Post

@Composable
fun CarPostsItem (modifier: Modifier = Modifier,
item: Post) {

    Card(modifier = modifier, elevation = 3.dp, shape = RoundedCornerShape(4.dp)) {
        Column {
            Image(modifier = Modifier
                .height(194.dp)
                .fillMaxWidth(), painter = rememberAsyncImagePainter(model = item.img), contentDescription = "car image", contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(8.dp))
            Text(modifier = Modifier
                .padding(16.dp, 0.dp)
                .heightIn(0.dp, 64.dp), style = MaterialTheme.typography.subtitle2, text = item.text)
            Spacer(modifier = Modifier.height(8.dp))
            Text(modifier = Modifier.padding(16.dp, 0.dp), style = MaterialTheme.typography.subtitle1, text = item.created_at, color = Color.LightGray)
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 16.dp, 0.dp), horizontalArrangement = Arrangement.End) {
                Row() {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.LightGray)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = item.like_count.toString(), color = Color.LightGray)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Favorite", tint = Color.LightGray)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = item.comment_count.toString(), color = Color.LightGray)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
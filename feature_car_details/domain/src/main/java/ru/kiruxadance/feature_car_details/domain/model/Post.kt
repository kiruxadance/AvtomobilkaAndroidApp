package ru.kiruxadance.feature_car_details.domain.model

data class Post(
    val author: User,
    val comment_count: Int,
    val created_at: String,
    val id: Int,
    val img: String,
    val like_count: Int,
    val text: String
)
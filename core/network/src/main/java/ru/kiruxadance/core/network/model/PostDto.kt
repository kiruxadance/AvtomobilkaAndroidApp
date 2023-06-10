package ru.kiruxadance.core.network.model

data class PostDto(
    val author: UserDto,
    val comment_count: Int,
    val created_at: String,
    val id: Int,
    val img: String,
    val like_count: Int,
    val text: String
)
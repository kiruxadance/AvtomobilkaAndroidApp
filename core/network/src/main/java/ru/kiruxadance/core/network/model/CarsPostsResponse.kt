package ru.kiruxadance.core.network.model

data class CarsPostsResponse(
    val posts: List<PostDto>,
    val user: UserDto
)
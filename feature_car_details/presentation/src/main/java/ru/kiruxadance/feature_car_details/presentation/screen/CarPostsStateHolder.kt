package ru.kiruxadance.feature_car_details.presentation.screen

import ru.kiruxadance.feature_car_details.domain.model.CarPosts

data class CarPostsStateHolder(
    val isLoading: Boolean = false,
    val data: CarPosts? = null,
    val error: String = ""
)
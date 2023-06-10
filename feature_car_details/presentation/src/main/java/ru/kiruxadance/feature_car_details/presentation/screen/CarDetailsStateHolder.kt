package ru.kiruxadance.feature_car_details.presentation.screen

import ru.kiruxadance.feature_car_details.domain.model.CarDetails

data class CarDetailsStateHolder(
    val isLoading: Boolean = false,
    val data: CarDetails? = null,
    val error: String = ""
)
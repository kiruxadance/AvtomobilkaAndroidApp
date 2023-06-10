package ru.kiruxadance.feature_cars_list.presentation.screen

import ru.kiruxadance.feature_cars_list.domain.model.Car

data class CarsStateHolder(
    val isLoading: Boolean = false,
    val data: List<Car>? = null,
    val error: String = ""
)
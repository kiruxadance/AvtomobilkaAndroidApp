package ru.kiruxadance.avtomobilkaandroidapp.navigation

import ru.kiruxadance.feature_car_details.presentation.navigation.CarDetailsApi
import ru.kiruxadance.feature_cars_list.presentation.navigation.CarsApi

data class NavigationProvider(
    val carsApi: CarsApi,
    val carDetailsApi: CarDetailsApi
)
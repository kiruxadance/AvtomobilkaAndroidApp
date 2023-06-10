package ru.kiruxadance.feature_cars_list.domain.repository

import ru.kiruxadance.feature_cars_list.domain.model.Car

interface CarRepository {
    suspend fun getCars(): List<Car>
}
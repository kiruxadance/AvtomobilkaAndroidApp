package ru.kiruxadance.feature_car_details.domain.repository

import ru.kiruxadance.feature_car_details.domain.model.CarDetails
import ru.kiruxadance.feature_car_details.domain.model.CarPosts

interface CarDetailsRepository {
    suspend fun getCarDetails(id: String) : CarDetails
    suspend fun getCarPosts(id: String) : CarPosts
}
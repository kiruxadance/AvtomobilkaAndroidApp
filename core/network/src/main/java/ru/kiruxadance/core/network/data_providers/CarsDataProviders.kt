package ru.kiruxadance.core.network.data_providers

import ru.kiruxadance.core.network.ApiService
import javax.inject.Inject

class CarsDataProviders @Inject constructor(
    private val apiService: ApiService
){
    suspend fun getCars() = apiService.getCars()

    suspend fun getCarsDetails(id: String) = apiService.getCarDetails(id)

    suspend fun getCarPosts(id: String) = apiService.getCarPosts(id)
}
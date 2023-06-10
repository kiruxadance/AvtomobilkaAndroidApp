package ru.kiruxadance.feature_car_details.data.repository

import ru.kiruxadance.core.network.data_providers.CarsDataProviders
import ru.kiruxadance.feature_car_details.data.mapper.toDomainCarDetails
import ru.kiruxadance.feature_car_details.data.mapper.toDomainCarPosts
import ru.kiruxadance.feature_car_details.domain.model.CarDetails
import ru.kiruxadance.feature_car_details.domain.model.CarPosts
import ru.kiruxadance.feature_car_details.domain.repository.CarDetailsRepository
import javax.inject.Inject

class CarDetailsRepositoryImpl @Inject constructor(
    private val carsDataProviders: CarsDataProviders
): CarDetailsRepository {
    override suspend fun getCarDetails(id: String): CarDetails {
        return carsDataProviders.getCarsDetails(id).toDomainCarDetails()
    }

    override suspend fun getCarPosts(id: String): CarPosts {
        return carsDataProviders.getCarPosts(id).toDomainCarPosts()
    }
}
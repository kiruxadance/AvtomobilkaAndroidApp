package ru.kiruxadance.feature_cars_list.data.repository

import ru.kiruxadance.core.network.data_providers.CarsDataProviders
import ru.kiruxadance.feature_cars_list.data.mapper.toDomainCars
import ru.kiruxadance.feature_cars_list.domain.model.Car
import ru.kiruxadance.feature_cars_list.domain.repository.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val carsDataProviders: CarsDataProviders
): CarRepository {
    override suspend fun getCars(): List<Car> {
        return carsDataProviders.getCars().toDomainCars()
    }
}
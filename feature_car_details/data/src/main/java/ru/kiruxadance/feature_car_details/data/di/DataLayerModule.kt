package ru.kiruxadance.feature_car_details.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.network.data_providers.CarsDataProviders
import ru.kiruxadance.feature_car_details.data.repository.CarDetailsRepositoryImpl
import ru.kiruxadance.feature_car_details.domain.repository.CarDetailsRepository

@Module
@InstallIn(SingletonComponent::class)
object DataLayerModule {
    @Provides
    fun provideCarDetailsRepository(carsDataProviders: CarsDataProviders): CarDetailsRepository {
        return CarDetailsRepositoryImpl(carsDataProviders)
    }
}
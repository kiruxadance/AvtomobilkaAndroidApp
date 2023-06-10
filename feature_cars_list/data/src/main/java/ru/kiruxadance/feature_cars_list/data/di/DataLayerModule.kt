package ru.kiruxadance.feature_cars_list.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.core.network.data_providers.CarsDataProviders
import ru.kiruxadance.feature_cars_list.data.repository.CarRepositoryImpl
import ru.kiruxadance.feature_cars_list.domain.repository.CarRepository

@Module
@InstallIn(SingletonComponent::class)
object DataLayerModule {
    @Provides
    fun provideCarRepository(carsDataProviders: CarsDataProviders) : CarRepository {
        return CarRepositoryImpl(carsDataProviders)
    }
}
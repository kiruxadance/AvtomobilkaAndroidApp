package ru.kiruxadance.feature_cars_list.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_cars_list.domain.repository.CarRepository
import ru.kiruxadance.feature_cars_list.domain.use_cases.GetCarsUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {
    @Provides
    fun provideGetCarsUseCase(carRepository: CarRepository): GetCarsUseCase {
        return GetCarsUseCase(carRepository)
    }
}
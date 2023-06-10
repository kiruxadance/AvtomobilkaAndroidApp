package ru.kiruxadance.feature_car_details.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_car_details.domain.repository.CarDetailsRepository
import ru.kiruxadance.feature_car_details.domain.use_cases.GetCarDetailsUseCase
import ru.kiruxadance.feature_car_details.domain.use_cases.GetCarPostsUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {

    @Provides
    fun provideGetCarDetailsUseCase(carDetailsRepository: CarDetailsRepository): GetCarDetailsUseCase {
        return GetCarDetailsUseCase(carDetailsRepository)
    }

    @Provides
    fun provideGetCarPostsUseCase(carDetailsRepository: CarDetailsRepository): GetCarPostsUseCase {
        return GetCarPostsUseCase(carDetailsRepository)
    }
}
package ru.kiruxadance.feature_car_details.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_car_details.presentation.navigation.CarDetailsApi
import ru.kiruxadance.feature_car_details.presentation.navigation.CarDetailsApiImpl

@Module
@InstallIn(SingletonComponent::class)
object UIModule {

    @Provides
    fun provideCarDetailsApi(): CarDetailsApi {
        return CarDetailsApiImpl()
    }
}
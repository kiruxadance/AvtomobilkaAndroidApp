package ru.kiruxadance.avtomobilkaandroidapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.avtomobilkaandroidapp.navigation.NavigationProvider
import ru.kiruxadance.feature_car_details.presentation.navigation.CarDetailsApi
import ru.kiruxadance.feature_cars_list.presentation.navigation.CarsApi

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNavigationProvider(carsApi: CarsApi, carDetailsApi: CarDetailsApi): NavigationProvider {
        return NavigationProvider(carsApi, carDetailsApi)
    }
}
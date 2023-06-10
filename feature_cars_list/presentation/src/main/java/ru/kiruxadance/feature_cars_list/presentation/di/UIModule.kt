package ru.kiruxadance.feature_cars_list.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.kiruxadance.feature_cars_list.presentation.navigation.CarsApi
import ru.kiruxadance.feature_cars_list.presentation.navigation.CarsApiImpl

@Module
@InstallIn(SingletonComponent::class)
object UIModule {

    @Provides
    fun provideCarsApi(): CarsApi {
        return CarsApiImpl()
    }
}

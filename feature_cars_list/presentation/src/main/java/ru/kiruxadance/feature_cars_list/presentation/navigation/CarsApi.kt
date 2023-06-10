package ru.kiruxadance.feature_cars_list.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import ru.kiruxadance.core.feature_api.FeatureApi

interface CarsApi: FeatureApi


class CarsApiImpl: CarsApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalTickerFeatureApi.registerGraph(navController, navGraphBuilder)
    }
}
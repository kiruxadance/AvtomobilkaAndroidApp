package ru.kiruxadance.feature_car_details.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import ru.kiruxadance.core.feature_api.FeatureApi

interface CarDetailsApi: FeatureApi{
}

class CarDetailsApiImpl: CarDetailsApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalCarDetailsApi.registerGraph(navController, navGraphBuilder)
    }

}
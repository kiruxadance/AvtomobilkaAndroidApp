package ru.kiruxadance.feature_car_details.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.kiruxadance.core.common.navigation_constants.CarsDetailsFeature
import ru.kiruxadance.core.feature_api.FeatureApi
import ru.kiruxadance.feature_car_details.presentation.screen.CarDetailsScreen
import ru.kiruxadance.feature_car_details.presentation.screen.CarDetailsViewModel

object InternalCarDetailsApi : FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            route = CarsDetailsFeature.nestedRoute,
            startDestination = CarsDetailsFeature.carDetailsScreenRoute)
        {
            composable(CarsDetailsFeature.carDetailsScreenRoute) {
                val viewModel = hiltViewModel<CarDetailsViewModel>()
                CarDetailsScreen(viewModel = viewModel, navController)
            }
        }
    }
}
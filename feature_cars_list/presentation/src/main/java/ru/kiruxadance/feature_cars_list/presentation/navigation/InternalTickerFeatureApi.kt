package ru.kiruxadance.feature_cars_list.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.kiruxadance.core.common.navigation_constants.CarsFeature
import ru.kiruxadance.core.feature_api.FeatureApi
import ru.kiruxadance.feature_cars_list.presentation.screen.CarsScreen
import ru.kiruxadance.feature_cars_list.presentation.screen.CarsViewModel

internal object InternalTickerFeatureApi : FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = CarsFeature.carScreenRoute, route = CarsFeature.nestedRoute) {
            composable(CarsFeature.carScreenRoute) {
                val viewModel = hiltViewModel<CarsViewModel>()
                CarsScreen(viewModel = viewModel, navController)
            }
        }
    }
}
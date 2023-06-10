package ru.kiruxadance.avtomobilkaandroidapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.kiruxadance.core.common.navigation_constants.CarsFeature

@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {
    NavHost(navController = navController, startDestination = CarsFeature.nestedRoute) {
        navigationProvider.carsApi.registerGraph(navController, this)
        navigationProvider.carDetailsApi.registerGraph(navController, this)
    }
}
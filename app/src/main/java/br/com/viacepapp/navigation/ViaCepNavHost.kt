package br.com.viacepapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.viacepapp.ui.screens.HomeViaCepScreen
import br.com.viacepapp.ui.viewmodels.HomeViewModel

const val homeRoute = "homeRoute"

@Composable
fun ViaCepNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = homeRoute
    ) {
        homeScreen(navHostController)
    }
}

fun NavGraphBuilder.homeScreen(
    navController: NavController
) {
    composable(homeRoute) {
        val viewModel = hiltViewModel<HomeViewModel>()
        val state by viewModel.uiState.collectAsState()

        HomeViaCepScreen(
            state = state,
            viewModel = viewModel,
            navController = navController
        )
    }
}
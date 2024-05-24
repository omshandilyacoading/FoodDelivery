package eu.tutorials.myapplication10

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun trans() {
    val navController = rememberNavController()
    val viewModel = remember { MainViewModel() }

    NavHost(navController, startDestination = "First_Page") {
        composable("First_Page") { First_Page(navController) }
        composable("login_page") { login_page(navController) }
        composable("Page_three") {
            Page_three(
                navController = navController,
                recipeViewModel = viewModel,
                modifier = Modifier.fillMaxSize()
            )
        }
        composable("Page_four") { Page_four(navController, viewModel) }
    }
}


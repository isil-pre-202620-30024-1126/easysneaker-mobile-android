package pe.isil.easyvet

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.easyvet.features.auth.presentation.LoginScreen
import pe.isil.easyvet.features.home.presentation.HomeScreen
import pe.isil.easyvet.features.onboarding.presentation.OnBoardingScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "onboarding") {

        composable("onboarding") {
            OnBoardingScreen {
                navController.navigate("login")
            }
        }

        composable("login") {
            LoginScreen {
                navController.navigate("home")
            }
        }

        composable ("home"){
            HomeScreen()
        }

    }
    
}

@Preview(showBackground = true)
@Composable
fun AppNavHostPreview() {
    AppNavHost()
}
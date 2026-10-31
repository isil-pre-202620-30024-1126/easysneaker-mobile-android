package pe.isil.easyvet

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import pe.isil.easyvet.features.auth.presentation.LoginScreen
import pe.isil.easyvet.features.onboarding.presentation.OnBoardingScreen
import pe.isil.easyvet.main.MainScreen

@Serializable
data object OnBoardingRoute

@Serializable
data object LoginRoute

@Serializable
data object MainRoute

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = OnBoardingRoute) {

        composable<OnBoardingRoute> {
            OnBoardingScreen {
                navController.navigate(LoginRoute) {
                    popUpTo(OnBoardingRoute) {
                        inclusive = true
                    }
                }
            }
        }

        composable<LoginRoute> {
            LoginScreen {
                navController.navigate(MainRoute) {
                    popUpTo(LoginRoute) {
                        inclusive = true
                    }
                }
            }
        }

        composable <MainRoute>{
            MainScreen()
        }

    }
    
}

@Preview(showBackground = true)
@Composable
fun AppNavHostPreview() {
    AppNavHost()
}
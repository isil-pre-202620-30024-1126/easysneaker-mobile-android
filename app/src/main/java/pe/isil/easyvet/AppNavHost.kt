package pe.isil.easyvet

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
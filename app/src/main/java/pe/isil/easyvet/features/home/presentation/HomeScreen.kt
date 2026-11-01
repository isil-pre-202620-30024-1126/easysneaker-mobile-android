package pe.isil.easyvet.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.isil.easyvet.core.designsystems.theme.EasyVetTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {

    val state = viewModel.state.collectAsStateWithLifecycle().value

    Column(
        modifier = modifier
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(8.dp))
        BannerSection()

        when {
            state.isLoading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }

            state.products.isNotEmpty() -> ProductList(
                products = state.products,
                favoriteProductsId = state.favoriteIds
            ) { id ->
                viewModel.toggleFavoriteProduct(id)
            }

        }

    }


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasyVetTheme(dynamicColor = false) {
        HomeScreen()
    }
}
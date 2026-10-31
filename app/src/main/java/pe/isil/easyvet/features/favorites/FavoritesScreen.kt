package pe.isil.easyvet.features.favorites

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import pe.isil.easyvet.features.home.presentation.HomeViewModel
import pe.isil.easyvet.features.home.presentation.ProductList

@Composable
fun FavoritesScreen(
    viewModel: HomeViewModel = viewModel()
) {

    val state = viewModel.state.collectAsStateWithLifecycle().value

    ProductList(state.products.filter { product ->
        state.favoriteProductIds.contains(product.id)
    },
        favoriteProductsId = state.favoriteProductIds
    ) { id ->
        viewModel.toggleFavorite(id)
    }
}
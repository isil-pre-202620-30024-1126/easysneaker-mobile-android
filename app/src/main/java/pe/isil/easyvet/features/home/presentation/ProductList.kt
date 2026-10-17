package pe.isil.easyvet.features.home.presentation

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import pe.isil.easyvet.features.home.domain.Product

@Composable
fun ProductList(products: List<Product>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(products) { product ->
            ProductCard(product = product)
        }
    }
}
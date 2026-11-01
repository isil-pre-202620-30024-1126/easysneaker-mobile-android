package pe.isil.easyvet.features.home.presentation

import pe.isil.easyvet.features.home.domain.Product

data class HomeState(
    val products: List<Product> = emptyList(),
    val favoriteIds: Set<Int> = emptySet(),
    val isLoading: Boolean = false
)

package pe.isil.easyvet.features.home.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pe.isil.easyvet.features.home.data.InMemoryProductRepository
import pe.isil.easyvet.features.home.domain.ProductRepository

class HomeViewModel(
    private val repository: ProductRepository = InMemoryProductRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun loadProducts() {
        _state.update { currentState ->
            currentState.copy(isLoading = true)
        }

        val products = repository.getProducts()

        _state.update { currentState ->
            currentState.copy(products = products, isLoading = false)
        }
    }

    fun toggleFavorite(productId: Int) {
        _state.update { currentState ->
            val newFavorites = if (currentState.favoriteProductIds.contains(productId)) {
                currentState.favoriteProductIds - productId
            } else {
                currentState.favoriteProductIds + productId
            }
            currentState.copy(favoriteProductIds = newFavorites)
        }

    }

    init {
        loadProducts()
    }

}
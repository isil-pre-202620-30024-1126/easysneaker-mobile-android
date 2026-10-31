package pe.isil.easyvet.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.isil.easyvet.features.home.data.InMemoryProductRepository
import pe.isil.easyvet.features.home.domain.GetProductsUseCase
import pe.isil.easyvet.features.home.domain.ProductRepository

class HomeViewModel(
    private val getProducts: GetProductsUseCase = GetProductsUseCase()
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun loadProducts() {

        viewModelScope.launch(Dispatchers.IO) {
            _state.update { currentState ->
                currentState.copy(isLoading = true)
            }

            val products = getProducts()

            _state.update { currentState ->
                currentState.copy(products = products, isLoading = false)
            }

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
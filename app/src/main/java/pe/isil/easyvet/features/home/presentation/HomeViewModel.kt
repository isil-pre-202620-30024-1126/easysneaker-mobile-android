package pe.isil.easyvet.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.isil.easyvet.features.favorites.data.InMemoryFavoriteRepository
import pe.isil.easyvet.features.favorites.domain.FavoriteRepository
import pe.isil.easyvet.features.favorites.domain.GetFavoritesUseCase
import pe.isil.easyvet.features.favorites.domain.ToggleFavoriteUseCase
import pe.isil.easyvet.features.home.domain.GetProductsUseCase

class HomeViewModel(
    private val getProducts: GetProductsUseCase = GetProductsUseCase(),
    favoriteRepository: FavoriteRepository =
        InMemoryFavoriteRepository(),
    private val getFavorites: GetFavoritesUseCase =
        GetFavoritesUseCase(favoriteRepository),

    private val toggleFavorite: ToggleFavoriteUseCase =
        ToggleFavoriteUseCase(favoriteRepository)
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun loadProducts() {

        viewModelScope.launch(Dispatchers.IO) {
            _state.update { currentState ->
                currentState.copy(isLoading = true)
            }

            val products = getProducts()
            val favoriteIds = getFavorites()

            _state.update { currentState ->
                currentState.copy(products = products, favoriteIds = favoriteIds, isLoading = false)
            }

        }

    }

    fun toggleFavoriteProduct(id: Int) {
        toggleFavorite(id)
        val favoriteIds = getFavorites()

        _state.update { currentState ->

            currentState.copy(favoriteIds = favoriteIds)
        }

    }

    init {
        loadProducts()
    }

}
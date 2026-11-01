package pe.isil.easyvet.features.favorites.domain

class ToggleFavoriteUseCase(private val favoriteRepository: FavoriteRepository ) {

    operator fun invoke(id: Int) {
        if (favoriteRepository.getFavorites().contains(id)) {
            favoriteRepository.removeFavorite(id)
        } else {
            favoriteRepository.addFavorite(id)
        }
    }
}
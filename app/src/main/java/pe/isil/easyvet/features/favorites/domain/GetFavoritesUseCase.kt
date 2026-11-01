package pe.isil.easyvet.features.favorites.domain

class GetFavoritesUseCase(private val favoriteRepository: FavoriteRepository) {

    operator fun invoke(): Set<Int> {
        return favoriteRepository.getFavorites()
    }

}
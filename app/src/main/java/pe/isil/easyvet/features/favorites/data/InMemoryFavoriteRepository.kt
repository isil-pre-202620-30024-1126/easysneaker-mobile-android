package pe.isil.easyvet.features.favorites.data

import pe.isil.easyvet.features.favorites.domain.FavoriteRepository

class InMemoryFavoriteRepository: FavoriteRepository {

    var favoriteIds: Set<Int> = emptySet()

    override fun getFavorites(): Set<Int> {
        return favoriteIds
    }

    override suspend fun addFavorite(id: Int) {
        favoriteIds += id
    }

    override suspend fun removeFavorite(id: Int) {
        favoriteIds -= id
    }
}
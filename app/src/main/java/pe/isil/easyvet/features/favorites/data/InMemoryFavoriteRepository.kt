package pe.isil.easyvet.features.favorites.data

import android.util.Log
import pe.isil.easyvet.features.favorites.domain.FavoriteRepository

class InMemoryFavoriteRepository: FavoriteRepository {

    var favoriteIds: Set<Int> = emptySet()

    override fun getFavorites(): Set<Int> {
        return favoriteIds
    }

    override fun addFavorite(id: Int) {
        favoriteIds += id
    }

    override fun removeFavorite(id: Int) {
        favoriteIds -= id
    }
}
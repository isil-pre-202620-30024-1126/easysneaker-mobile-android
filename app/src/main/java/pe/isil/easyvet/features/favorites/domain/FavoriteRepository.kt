package pe.isil.easyvet.features.favorites.domain

interface FavoriteRepository {

    fun getFavorites(): Set<Int>

    suspend fun addFavorite(id: Int)

    suspend fun removeFavorite(id: Int)
}
package pe.isil.easyvet.features.favorites.domain

interface FavoriteRepository {

    fun getFavorites(): Set<Int>

    fun addFavorite(id: Int)

    fun removeFavorite(id: Int)
}
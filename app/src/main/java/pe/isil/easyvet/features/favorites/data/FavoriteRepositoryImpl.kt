package pe.isil.easyvet.features.favorites.data

import androidx.room3.Room
import androidx.sqlite.driver.AndroidSQLiteDriver
import pe.isil.easyvet.MyApplication
import pe.isil.easyvet.features.favorites.data.local.AppDatabase
import pe.isil.easyvet.features.favorites.data.local.FavoriteDao
import pe.isil.easyvet.features.favorites.data.local.FavoriteEntity
import pe.isil.easyvet.features.favorites.domain.FavoriteRepository

class FavoriteRepositoryImpl(
    private var dao: FavoriteDao = Room.databaseBuilder< AppDatabase>(
        MyApplication.INSTANCE.applicationContext,
        "easyvet.db").setDriver(AndroidSQLiteDriver()).build().favoriteDao()
): FavoriteRepository {
    override fun getFavorites(): Set<Int> {
        return dao.getFavorites().map { entity -> entity.id }.toSet()
    }

    override suspend fun addFavorite(id: Int) {
        dao.addFavorite(FavoriteEntity(id))
    }

    override suspend fun removeFavorite(id: Int) {
        dao.removeFavorite(FavoriteEntity(id))
    }
}
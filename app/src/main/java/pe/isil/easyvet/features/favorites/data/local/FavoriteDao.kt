package pe.isil.easyvet.features.favorites.data.local

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query

@Dao
interface FavoriteDao {

    @Query("select * from favorites")
    fun getFavorites(): List<FavoriteEntity>

    @Insert
    suspend fun addFavorite(entity: FavoriteEntity)

    @Delete
    suspend fun removeFavorite(entity: FavoriteEntity)

}
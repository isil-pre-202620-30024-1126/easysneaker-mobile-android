package pe.isil.easyvet.features.favorites.data.local

import androidx.room3.Database
import androidx.room3.RoomDatabase

@Database(entities = [FavoriteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
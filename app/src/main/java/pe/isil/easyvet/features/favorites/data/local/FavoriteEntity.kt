package pe.isil.easyvet.features.favorites.data.local

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey
    val id: Int
)

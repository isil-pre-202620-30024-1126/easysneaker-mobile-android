package pe.isil.easyvet.features.home.data

import kotlinx.coroutines.delay
import pe.isil.easyvet.features.home.domain.Product
import pe.isil.easyvet.features.home.domain.ProductRepository
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

class InMemoryProductRepository : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        delay(2000.milliseconds)
        return listOf(
            Product(
                id = 1,
                name = "Royal Canin Maxi Puppy",
                image = "https://i.imgur.com/WkZEOU6.png",
                rating = 4.8
            ),
            Product(
                id = 2,
                name = "Eukanuba Active Adult",
                image = "https://i.imgur.com/guSk1sh.png",
                rating = 4.7
            ),
            Product(
                id = 3,
                name = "Whiskas Adult Chicken Flavor",
                image = "https://i.imgur.com/dRC9dEB.png",
                rating = 4.5
            ),
            Product(
                id = 4,
                name = "Pedigree Dentastix",
                image = "https://i.imgur.com/Ir1nz0q.png",
                rating = 4.6
            ),
            Product(
                id = 5,
                name = "Purina One Kitten",
                image = "https://i.imgur.com/NWqqHDJ.png",
                rating = 4.9
            ),
            Product(
                id = 6,
                name = "Pro Plan Adult Sensitive Skin",
                image = "https://i.imgur.com/1XamSfG.png",
                rating = 4.8
            ),
            Product(
                id = 7,
                name = "Catit Lavender Clumping Litter",
                image = "https://i.imgur.com/8vgVmrv.png",
                rating = 4.4
            )
        )
    }


}

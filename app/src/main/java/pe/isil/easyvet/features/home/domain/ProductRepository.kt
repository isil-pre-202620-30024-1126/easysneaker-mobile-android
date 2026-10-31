package pe.isil.easyvet.features.home.domain

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}
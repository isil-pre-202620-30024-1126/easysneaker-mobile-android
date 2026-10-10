package pe.isil.easyvet.features.home.domain

interface ProductRepository {
    fun getProducts(): List<Product>
}
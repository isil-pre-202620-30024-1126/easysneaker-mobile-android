package pe.isil.easyvet.features.home.data

import pe.isil.easyvet.features.home.data.remote.ProductApi
import pe.isil.easyvet.features.home.domain.Product
import pe.isil.easyvet.features.home.domain.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRepositoryImpl
    (
    private val api: ProductApi = Retrofit.Builder()
        .baseUrl("https://petapi-591531460223.us-central1.run.app/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductApi::class.java)

) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        val response = api.getProducts()
        if (response.isSuccessful) {
            response.body()?.let { productsDto ->
                val products = productsDto.products
                return products.map { dto ->
                    Product(id = dto.id, name = dto.title, image = dto.image, rating = dto.rating)
                }.toList()
            }
        }
        return emptyList()
    }
}
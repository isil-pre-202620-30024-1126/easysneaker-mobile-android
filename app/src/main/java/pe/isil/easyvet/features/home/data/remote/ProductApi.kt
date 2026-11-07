package pe.isil.easyvet.features.home.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): Response<ProductsDto>
}
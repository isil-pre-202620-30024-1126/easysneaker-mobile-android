package pe.isil.easyvet.features.home.data.remote

import com.google.gson.annotations.SerializedName

data class ProductsDto(
    val count: Int,
    @SerializedName("results")
    val products: List<ProductDto>
)

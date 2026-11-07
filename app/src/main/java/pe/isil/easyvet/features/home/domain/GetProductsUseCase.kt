package pe.isil.easyvet.features.home.domain

import pe.isil.easyvet.features.home.data.ProductRepositoryImpl

class GetProductsUseCase(
    private val repository: ProductRepository = ProductRepositoryImpl()
) {

    @Override
    suspend operator fun invoke(): List<Product> {
        return repository.getProducts()
    }
}


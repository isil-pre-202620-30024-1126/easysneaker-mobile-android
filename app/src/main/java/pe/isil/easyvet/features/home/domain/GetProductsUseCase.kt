package pe.isil.easyvet.features.home.domain

import pe.isil.easyvet.features.home.data.InMemoryProductRepository

class GetProductsUseCase(
    private val repository: ProductRepository = InMemoryProductRepository()
) {

    @Override
    operator fun invoke(): List<Product> {
        return repository.getProducts()
    }
}


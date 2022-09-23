package com.loxasoft.ecomercedesa.ecodesa.domain.service;

import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;
import com.loxasoft.ecomercedesa.ecodesa.domain.repository.ProductRepository;

public class DomainProductService implements ProductService{

  private final ProductRepository productRepository;

    public DomainProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return this.productRepository.getProducts();
    }

    @Override
    public Product getProduct(Integer id) {
        return this.productRepository.getProduct(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        /*if (product.getId() != null){
            product.setDateUpdated(LocalDateTime.now());
        }else{
            product.setCode(UUID.randomUUID().toString());
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
        }*/

        return this.productRepository.saveProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = getProduct(id);
        this.productRepository.deleteProductById(product.getId());
    }
}

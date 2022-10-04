package com.loxasoft.ecomercedesa.ecodesa.application.service;

import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;
import com.loxasoft.ecomercedesa.ecodesa.domain.puerto.ProductRepository;

import java.time.LocalDateTime;

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
    public Product getProductById(Integer id) {
        return this.productRepository.getProduct(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        if (product.getId() != null){
            product.setDateUpdated(LocalDateTime.now());
        }else{
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
        }
        return this.productRepository.saveProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteProductById(id);
    }
}

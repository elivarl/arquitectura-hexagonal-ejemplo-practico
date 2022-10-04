package com.loxasoft.ecomercedesa.ecodesa.infrastructure.adaptador;

import com.loxasoft.ecomercedesa.ecodesa.infrastructure.exceptions.ResourceNotFoundException;
import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;
import com.loxasoft.ecomercedesa.ecodesa.domain.puerto.ProductRepository;
import com.loxasoft.ecomercedesa.ecodesa.infrastructure.entity.ProductEntity;
import com.loxasoft.ecomercedesa.ecodesa.infrastructure.rest.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Slf4j
public class ProductRepositoryMySQL implements ProductRepository {

    private final ProductCrudRepositoryMySQL productoCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductRepositoryMySQL(ProductCrudRepositoryMySQL productoCrudRepository) {
        this.productoCrudRepository = productoCrudRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return this.productMapper.toProducts(this.productoCrudRepository.findAll());
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        ProductEntity producto = this.productoCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        return Optional.of(this.productMapper.toProduct(producto));
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = this.productMapper.toProductEnity(product);
        System.out.println("Code: "+ productEntity.getCode());
        return this.productMapper.toProduct(this.productoCrudRepository.save(productEntity));
    }

    @Override
    public void deleteProductById(Integer id) {
        ProductEntity productEntity = this.productoCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        this.productoCrudRepository.deleteById(productEntity.getId());
    }
}

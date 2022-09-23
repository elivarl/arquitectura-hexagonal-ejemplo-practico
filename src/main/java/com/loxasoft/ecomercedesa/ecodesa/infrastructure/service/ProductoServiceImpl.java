package com.loxasoft.ecomercedesa.ecodesa.infrastructure.service;

import com.loxasoft.ecomercedesa.ecodesa.infrastructure.exceptions.ResourceNotFoundException;
import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;
import com.loxasoft.ecomercedesa.ecodesa.domain.repository.ProductRepository;
import com.loxasoft.ecomercedesa.ecodesa.infrastructure.crud.ProductCrudRepository;
import com.loxasoft.ecomercedesa.ecodesa.infrastructure.entity.ProductEntity;
import com.loxasoft.ecomercedesa.ecodesa.infrastructure.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductRepository {

    private final ProductCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductoServiceImpl(ProductCrudRepository productoCrudRepository) {
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
        if (product.getId() != null){
            productEntity.setDateUpdated(LocalDateTime.now());
        }else{
            productEntity.setDateCreated(LocalDateTime.now());
            productEntity.setDateUpdated(LocalDateTime.now());
        }
        return this.productMapper.toProduct(this.productoCrudRepository.save(productEntity));
    }

    @Override
    public void deleteProductById(Integer id) {

    }
}

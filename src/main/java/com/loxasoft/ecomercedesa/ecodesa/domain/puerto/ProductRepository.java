package com.loxasoft.ecomercedesa.ecodesa.domain.puerto;

import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Optional <Product> getProduct (Integer id);
    Product saveProduct (Product product);
    void deleteProductById(Integer id);
}

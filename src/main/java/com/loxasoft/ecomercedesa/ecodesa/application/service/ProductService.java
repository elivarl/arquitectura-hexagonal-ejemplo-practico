package com.loxasoft.ecomercedesa.ecodesa.application.service;

import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;

public interface ProductService {
    Iterable<Product> getProducts();
    Product getProductById (Integer id);
    Product saveProduct (Product product);
    void deleteProduct(Integer id);
}

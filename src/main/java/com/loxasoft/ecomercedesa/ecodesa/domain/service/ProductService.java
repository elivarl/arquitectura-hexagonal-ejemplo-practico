package com.loxasoft.ecomercedesa.ecodesa.domain.service;

import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;

public interface ProductService {
    Iterable<Product> getProducts();
    Product getProduct (Integer id);
    Product saveProduct (Product product);
    void deleteProduct(Integer id);
}

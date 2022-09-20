package com.loxasoft.ecomercedesa.ecodesa.service;

import com.loxasoft.ecomercedesa.ecodesa.exceptions.ResourceNotFoundException;
import com.loxasoft.ecomercedesa.ecodesa.model.Product;
import com.loxasoft.ecomercedesa.ecodesa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class ProductServiceImpl  implements  ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProduct(Integer id) {
        //sin manejo de excepciones al buscar
        //return this.productRepository.findById(id).get();
         return this.productRepository.findById(id).orElseThrow(
                 ()-> new ResourceNotFoundException("Recurso no encontrado")
         );
    }

    @Override
    public Product saveProduct(Product product) {
        if (product.getId() != null){
            product.setDateUpdated(LocalDateTime.now());
        }else{
            product.setCode(UUID.randomUUID().toString());
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
        }

        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = getProduct(id);
        this.productRepository.deleteById(product.getId());
    }
}

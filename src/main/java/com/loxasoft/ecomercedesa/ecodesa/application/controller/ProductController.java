package com.loxasoft.ecomercedesa.ecodesa.application.controller;

import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;
import com.loxasoft.ecomercedesa.ecodesa.domain.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> getProducts(){
        return this.productService.getProducts();
    }

    @PostMapping
    public  Product saveProduct(@RequestBody Product product){
        log.info("Hola saveProduct");
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct (@PathVariable Integer id){
        log.info("Id "+id);
        log.info("Product {}",this.productService.getProduct(id));
        return this.productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){

        //this.productService.deleteProduct(id);
    }

}

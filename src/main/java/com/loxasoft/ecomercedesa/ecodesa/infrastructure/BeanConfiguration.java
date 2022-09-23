package com.loxasoft.ecomercedesa.ecodesa.infrastructure;

import com.loxasoft.ecomercedesa.ecodesa.domain.repository.ProductRepository;
import com.loxasoft.ecomercedesa.ecodesa.domain.service.DomainProductService;
import com.loxasoft.ecomercedesa.ecodesa.domain.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductService productBeanService(ProductRepository productRepository){
        return new DomainProductService(productRepository);
    }
}

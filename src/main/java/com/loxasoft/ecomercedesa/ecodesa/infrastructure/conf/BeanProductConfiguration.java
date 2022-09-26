package com.loxasoft.ecomercedesa.ecodesa.infrastructure.conf;

import com.loxasoft.ecomercedesa.ecodesa.domain.puerto.ProductRepository;
import com.loxasoft.ecomercedesa.ecodesa.application.service.DomainProductService;
import com.loxasoft.ecomercedesa.ecodesa.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProductConfiguration {

    @Bean
    ProductService productBeanService(final ProductRepository productRepository){
        return new DomainProductService(productRepository);
    }
}

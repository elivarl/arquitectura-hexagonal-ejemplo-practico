package com.loxasoft.ecomercedesa.ecodesa.infrastructure.adaptador;

import com.loxasoft.ecomercedesa.ecodesa.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepositoryMySQL extends CrudRepository<ProductEntity, Integer> {
}

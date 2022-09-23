package com.loxasoft.ecomercedesa.ecodesa.infrastructure.crud;

import com.loxasoft.ecomercedesa.ecodesa.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}

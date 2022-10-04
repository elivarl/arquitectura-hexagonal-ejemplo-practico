package com.loxasoft.ecomercedesa.ecodesa.infrastructure.rest.mapper;

import com.loxasoft.ecomercedesa.ecodesa.domain.model.Product;
import com.loxasoft.ecomercedesa.ecodesa.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
           // @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated")
            }
    )
    Product toProduct(ProductEntity producto);
    Iterable<Product> toProducts(Iterable<ProductEntity> productoEntity);

    @InheritInverseConfiguration
    ProductEntity toProductEnity (Product product);

}

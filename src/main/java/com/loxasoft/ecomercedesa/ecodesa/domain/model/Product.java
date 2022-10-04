package com.loxasoft.ecomercedesa.ecodesa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data //getter y setter
public class Product {
    private Integer id;
    private  String code;
    private String name;
    private String description;
    private String urlImage;
    private Double price;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public Product() {
        this.code = UUID.randomUUID().toString();
    }
}

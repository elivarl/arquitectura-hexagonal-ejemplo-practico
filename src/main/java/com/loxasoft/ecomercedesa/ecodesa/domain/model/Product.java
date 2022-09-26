package com.loxasoft.ecomercedesa.ecodesa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data //getter y setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String code;
    private String name;
    private String description;
    private String urlImage;
    private Double price;

    public Product() {
        this.code = UUID.randomUUID().toString();
    }
}

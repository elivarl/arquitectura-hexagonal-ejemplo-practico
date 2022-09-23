package com.loxasoft.ecomercedesa.ecodesa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data //getter y setter
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String code;
    private String name;
    private String description;
    private String urlImage;
    private Double price;
}

package com.loxasoft.ecomercedesa.ecodesa.domain.model;

import lombok.Data;

import javax.persistence.*;
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;

    //private List<Product> products;

}

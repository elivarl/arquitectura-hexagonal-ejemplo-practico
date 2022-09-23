package com.loxasoft.ecomercedesa.ecodesa.infrastructure.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
public class UserEntity {
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

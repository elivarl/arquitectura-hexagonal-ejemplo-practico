package com.loxasoft.ecomercedesa.ecodesa.infrastructure.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@AllArgsConstructor // para que funcione las validaciones
@NoArgsConstructor // para que no de error al obtener el producto con el getProduct(Integer id)
@Data //getter y setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String code;
    @Size(min = 4, max = 50, message = "Nombre de producto debe contener al menos 5 caracteres")
    @NotBlank(message = "Nombre de producto no debe estar en blanco")
    private String name;
    @NotBlank(message = "Descripción de producto no debe estar vacío")
    private String description;
    private String urlImagen;
    @NotNull(message = "Precio de producto es requerido")
    @Positive(message = "Precio no debe ser un número negativo o cero")
    private Double price;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;


}

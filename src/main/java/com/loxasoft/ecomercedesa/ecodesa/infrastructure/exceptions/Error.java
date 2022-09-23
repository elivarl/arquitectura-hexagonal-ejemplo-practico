package com.loxasoft.ecomercedesa.ecodesa.infrastructure.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Error {
    private String code;
    private String message;

}

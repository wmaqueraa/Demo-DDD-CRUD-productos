package com.example.productosapi.infrastructure.rest.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {


    @NotBlank(message = "El Apellido Paterno  es obligatorio")
    @Size(min = 3, max = 50, message = "El Apellido Paterno debe tener entre 3 y 50 caracteres")
    private String apellidoPaterno;

    @NotBlank(message = "El Apellido Materno  es obligatorio")
    @Size(min = 3, max = 50, message = "El Apellido Materno debe tener entre 3 y 50 caracteres")
    private String apellidoMaterno;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombres;

    @NotBlank(message = "El numero DNI es obligatorio")
    @Size(min = 3, max = 10, message = "El Numero de DNI debe tener entre 3 y 10 caracteres")
    private String numeroDni;

    @NotBlank(message = "El numero Telefono es obligatorio")
    @Size(min = 3, max = 12, message = "El Numero de Telefno debe tener entre 3 y 12 caracteres")
    private String telefono;

    private String sexo;

    private String fechaNacimiento;

}

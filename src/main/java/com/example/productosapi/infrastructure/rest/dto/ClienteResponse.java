package com.example.productosapi.infrastructure.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {

    private UUID id;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String numeroDni;
    private String telefono;
    private String sexo;
    private Boolean activo;
    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaActualizacion;
}

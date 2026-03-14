package com.example.productosapi.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Builder
public class Cliente {

    private final UUID id;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final String nombres;
    private final String numeroDni;
    private final String telefono;
    private final String sexo;
    private final Boolean activo;
    private final LocalDateTime fechaNacimiento;
    private final LocalDateTime fechaActualizacion;

    /**
     * Método para actualizar un cliente con nuevos valores
     */
    public Cliente actualizar(String apellidoPaterno, String apellidoMaterno, String nombres,
                              String telefono, String sexo, LocalDateTime fechaNacimiento) {
        return Cliente.builder()
                .id(this.id)
                .apellidoPaterno(apellidoPaterno)
                .apellidoMaterno(apellidoMaterno)
                .nombres(nombres)
                .numeroDni(this.numeroDni)
                .telefono(telefono)
                .sexo(sexo)
                .activo(this.activo)
                .fechaNacimiento(fechaNacimiento)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

    /**
     * Método para cambiar el estado activo del cliente
     */
    public Cliente cambiarEstado(Boolean activo) {
        return Cliente.builder()
                .id(this.id)
                .apellidoPaterno(this.apellidoPaterno)
                .apellidoMaterno(this.apellidoMaterno)
                .nombres(this.nombres)
                .numeroDni(this.numeroDni)
                .telefono(this.telefono)
                .sexo(this.sexo)
                .activo(activo)
                .fechaNacimiento(this.fechaNacimiento)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

    /**
     * Método para verificar si el cliente está activo
     */
    public boolean estaActivo() {
        return Boolean.TRUE.equals(this.activo);
    }

    /**
     * Método para obtener el nombre completo del cliente
     */
    public String getNombreCompleto() {
        return this.apellidoPaterno + " " + this.apellidoMaterno + ", " + this.nombres;
    }
}
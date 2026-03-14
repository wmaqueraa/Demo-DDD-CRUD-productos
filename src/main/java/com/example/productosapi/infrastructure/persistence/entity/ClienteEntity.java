package com.example.productosapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "clientes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ClienteEntity {

    @Id
    private UUID id;

    @Column(nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(nullable = false, length = 50)
    private String apellidoMaterno;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, unique = true, length = 10)
    private String numeroDni;

    @Column(length = 12)
    private String telefono;

    @Column(length = 10)
    private String sexo;

    @Column(nullable = false)
    private Boolean activo;

    @CreatedDate
    @Column(name = "fecha_nacimiento", nullable = false, updatable = false)
    private LocalDateTime fechaNacimiento;

    @LastModifiedDate
    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}

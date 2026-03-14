package com.example.productosapi.infrastructure.persistence.repository;

import com.example.productosapi.infrastructure.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {

    /**
     * Busca un cliente por su número de DNI
     */
    Optional<ClienteEntity> findByNumeroDni(String numeroDni);

    /**
     * Busca clientes por su estado activo
     */
    List<ClienteEntity> findByActivo(Boolean activo);

    /**
     * Busca clientes por sexo
     */
    List<ClienteEntity> findBySexo(String sexo);

    /**
     * Verifica si existe un cliente con el DNI proporcionado
     */
    boolean existsByNumeroDni(String numeroDni);
}
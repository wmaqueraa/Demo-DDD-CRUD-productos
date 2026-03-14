package com.example.productosapi.domain.repository;

import com.example.productosapi.domain.model.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {

    /**
     * Guarda un nuevo cliente o actualiza uno existente
     * @param cliente el cliente a guardar
     * @return el cliente guardado
     */
    Cliente save(Cliente cliente);

    /**
     * Busca un cliente por su ID
     * @param id el ID del cliente
     * @return un Optional con el cliente si existe
     */
    Optional<Cliente> findById(UUID id);

    /**
     * Busca un cliente por su número de DNI
     * @param numeroDni el DNI del cliente
     * @return un Optional con el cliente si existe
     */
    Optional<Cliente> findByNumeroDni(String numeroDni);

    /**
     * Obtiene todos los clientes
     * @return lista de clientes
     */
    List<Cliente> findAll();

    /**
     * Busca clientes por su estado activo
     * @param activo el estado a buscar
     * @return lista de clientes con el estado indicado
     */
    List<Cliente> findByActivo(Boolean activo);

    /**
     * Busca clientes por su sexo
     * @param sexo el sexo a buscar
     * @return lista de clientes con el sexo indicado
     */
    List<Cliente> findBySexo(String sexo);

    /**
     * Elimina un cliente por su ID
     * @param id el ID del cliente a eliminar
     */
    void deleteById(UUID id);

    /**
     * Verifica si existe un cliente con el DNI proporcionado
     * @param numeroDni el DNI a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsByNumeroDni(String numeroDni);
}
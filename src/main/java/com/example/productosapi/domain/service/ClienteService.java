package com.example.productosapi.domain.service;

import com.example.productosapi.domain.model.Cliente;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ClienteService {

    /**
     * Crea un nuevo cliente
     * @param cliente el cliente a crear
     * @return el cliente creado
     */
    Cliente crearCliente(Cliente cliente);

    /**
     * Obtiene un cliente por su ID
     * @param id el ID del cliente
     * @return el cliente encontrado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente obtenerClientePorId(UUID id);

    /**
     * Obtiene un cliente por su número de DNI
     * @param numeroDni el DNI del cliente
     * @return el cliente encontrado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente obtenerClientePorDni(String numeroDni);

    /**
     * Obtiene todos los clientes
     * @return lista de clientes
     */
    List<Cliente> obtenerTodosLosClientes();

    /**
     * Obtiene clientes por su estado activo
     * @param activo el estado a buscar
     * @return lista de clientes con el estado indicado
     */
    List<Cliente> obtenerClientesPorEstado(Boolean activo);

    /**
     * Obtiene clientes por sexo
     * @param sexo el sexo a buscar
     * @return lista de clientes con el sexo indicado
     */
    List<Cliente> obtenerClientesPorSexo(String sexo);

    /**
     * Actualiza un cliente existente
     * @param id el ID del cliente a actualizar
     * @param apellidoPaterno nuevo apellido paterno
     * @param apellidoMaterno nuevo apellido materno
     * @param nombres nuevos nombres
     * @param telefono nuevo teléfono
     * @param sexo nuevo sexo
     * @param fechaNacimiento nueva fecha de nacimiento
     * @return el cliente actualizado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente actualizarCliente(UUID id, String apellidoPaterno, String apellidoMaterno,
                              String nombres, String telefono, String sexo,
                              LocalDateTime fechaNacimiento);

    /**
     * Actualiza el estado (activo/inactivo) de un cliente
     * @param id el ID del cliente
     * @param activo el nuevo estado
     * @return el cliente actualizado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente actualizarEstadoCliente(UUID id, Boolean activo);

    /**
     * Elimina un cliente por su ID
     * @param id el ID del cliente a eliminar
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    void eliminarCliente(UUID id);
}
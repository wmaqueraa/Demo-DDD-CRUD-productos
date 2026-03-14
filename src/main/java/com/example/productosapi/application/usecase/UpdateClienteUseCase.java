package com.example.productosapi.application.usecase;

import com.example.productosapi.domain.model.Cliente;
import com.example.productosapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateClienteUseCase {

    private final ClienteService clienteService;

    /**
     * Actualiza los datos de un cliente existente
     * @param id ID del cliente a actualizar
     * @param apellidoPaterno nuevo apellido paterno
     * @param apellidoMaterno nuevo apellido materno
     * @param nombres nuevos nombres
     * @param telefono nuevo teléfono
     * @param sexo nuevo sexo
     * @param fechaNacimiento nueva fecha de nacimiento
     * @return el cliente actualizado
     */
    public Cliente execute(UUID id, String apellidoPaterno, String apellidoMaterno,
                           String nombres, String telefono, String sexo,
                           LocalDateTime fechaNacimiento) {
        return clienteService.actualizarCliente(id, apellidoPaterno, apellidoMaterno,
                nombres, telefono, sexo, fechaNacimiento);
    }

    /**
     * Actualiza el estado (activo/inactivo) de un cliente
     * @param id ID del cliente
     * @param activo nuevo estado
     * @return el cliente actualizado
     */
    public Cliente executeStateUpdate(UUID id, Boolean activo) {
        return clienteService.actualizarEstadoCliente(id, activo);
    }
}
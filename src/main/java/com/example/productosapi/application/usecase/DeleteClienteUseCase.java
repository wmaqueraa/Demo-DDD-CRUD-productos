package com.example.productosapi.application.usecase;

import com.example.productosapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeleteClienteUseCase {

    private final ClienteService clienteService;

    /**
     * Ejecuta el caso de uso para eliminar un cliente
     * @param id ID del cliente a eliminar
     */
    public void execute(UUID id) {
        clienteService.eliminarCliente(id);
    }
}

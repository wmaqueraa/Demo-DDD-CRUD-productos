package com.example.productosapi.application.usecase;


import com.example.productosapi.domain.model.Cliente;
import com.example.productosapi.domain.model.Producto;
import com.example.productosapi.domain.service.ClienteService;
import com.example.productosapi.domain.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateClienteUseCase {
    private final ClienteService clienteService;

    /**
     * Ejecuta el caso de uso
     * @param cliente el cliente a crear
     * @return el cliente creado
     */
    public Cliente execute(Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }
}

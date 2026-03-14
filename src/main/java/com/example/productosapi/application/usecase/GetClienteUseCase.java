package com.example.productosapi.application.usecase;

import com.example.productosapi.domain.model.Cliente;
import com.example.productosapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetClienteUseCase {
    private final ClienteService clienteService;

    /**
     * Obtiene un cliente por su ID
     * @param id el ID del cliente
     * @return el cliente encontrado
     */
    public Cliente executeById(UUID id) {
        return clienteService.obtenerClientePorId(id);
    }

    /**
     * Obtiene un cliente por su código
     * @param numero el código del cliente
     * @return el cliente encontrado
     */
    public Cliente executeByCodigo(String numero) {
        return clienteService.obtenerClientePorDni(numero);
    }

    /**
     * Obtiene todos los clientes
     * @return lista de todos los clientes
     */
    public List<Cliente> executeAll() {
        return clienteService.obtenerTodosLosClientes();
    }

    /**
     * Obtiene clientes por categoría
     * @param sexo la categoría a buscar
     * @return lista de clientes de la categoría
     */
    public List<Cliente> executeBySexo(String sexo) {
        return clienteService.obtenerClientesPorSexo(sexo);
    }

    /**
     * Obtiene clientes por estado
     * @param estado la categoría a buscar
     * @return lista de clientes de la estado
     */
    public List<Cliente> executeByEstado(Boolean estado) {
        return clienteService.obtenerClientesPorEstado(estado);
    }
    
}

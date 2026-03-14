package com.example.productosapi.infrastructure.rest.controller;

import com.example.productosapi.application.usecase.CreateClienteUseCase;
import com.example.productosapi.application.usecase.DeleteClienteUseCase;
import com.example.productosapi.application.usecase.GetClienteUseCase;
import com.example.productosapi.application.usecase.UpdateClienteUseCase;
import com.example.productosapi.domain.model.Cliente;
import com.example.productosapi.infrastructure.persistence.mapper.ClienteMapper;
import com.example.productosapi.infrastructure.rest.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para operaciones de Clientes
 */
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;
    private final GetClienteUseCase getClienteUseCase;
    private final UpdateClienteUseCase updateClienteUseCase;
    private final DeleteClienteUseCase deleteClienteUseCase;
    private final ClienteMapper mapper;

    /**
     * Crea un nuevo cliente
     */
    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@Valid @RequestBody ClienteRequest request) {
        Cliente cliente = mapper.toDomain(request);
        Cliente creado = createClienteUseCase.execute(cliente);
        return new ResponseEntity<>(mapper.toResponse(creado), HttpStatus.CREATED);
    }

    /**
     * Obtiene un cliente por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerCliente(@PathVariable UUID id) {
        Cliente cliente = getClienteUseCase.executeById(id);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }

    /**
     * Obtiene un cliente por su número de DNI
     */
    @GetMapping("/dni/{numeroDni}")
    public ResponseEntity<ClienteResponse> obtenerClientePorDni(@PathVariable String numeroDni) {
        Cliente cliente = getClienteUseCase.executeByCodigo(numeroDni);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }

    /**
     * Obtiene todos los clientes
     */
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obtenerTodosLosClientes() {
        List<Cliente> clientes = getClienteUseCase.executeAll();
        return ResponseEntity.ok(mapper.toResponseList(clientes));
    }

    /**
     * Obtiene clientes por estado activo/inactivo
     */
    @GetMapping("/estado/{activo}")
    public ResponseEntity<List<ClienteResponse>> obtenerClientesPorEstado(@PathVariable Boolean activo) {
        List<Cliente> clientes = getClienteUseCase.executeByEstado(activo);
        return ResponseEntity.ok(mapper.toResponseList(clientes));
    }

    /**
     * Obtiene clientes por sexo
     */
    @GetMapping("/sexo/{sexo}")
    public ResponseEntity<List<ClienteResponse>> obtenerClientesPorSexo(@PathVariable String sexo) {
        List<Cliente> clientes = getClienteUseCase.executeBySexo(sexo);
        return ResponseEntity.ok(mapper.toResponseList(clientes));
    }

    /**
     * Actualiza un cliente existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarCliente(
            @PathVariable UUID id,
            @Valid @RequestBody ClienteUpdateRequest request) {

        Cliente actualizado = updateClienteUseCase.execute(
                id,
                request.getApellidoPaterno(),
                request.getApellidoMaterno(),
                request.getNombres(),
                request.getTelefono(),
                request.getSexo(),
                request.getFechaNacimiento()
        );

        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    /**
     * Actualiza el estado de un cliente
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<ClienteResponse> actualizarEstadoCliente(
            @PathVariable UUID id,
            @Valid @RequestBody EstadoUpdateRequest request) {

        Cliente actualizado = updateClienteUseCase.executeStateUpdate(id, request.getActivo());
        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    /**
     * Elimina un cliente
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable UUID id) {
        deleteClienteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
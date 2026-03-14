package com.example.productosapi.domain.service;

import com.example.productosapi.domain.model.Cliente;
import com.example.productosapi.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        if (clienteRepository.existsByNumeroDni(cliente.getNumeroDni())) {
            throw new IllegalArgumentException("Ya existe un cliente con el DNI: " + cliente.getNumeroDni());
        }
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente obtenerClientePorId(UUID id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente obtenerClientePorDni(String numeroDni) {
        return clienteRepository.findByNumeroDni(numeroDni)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con DNI: " + numeroDni));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> obtenerClientesPorEstado(Boolean activo) {
        return clienteRepository.findByActivo(activo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> obtenerClientesPorSexo(String sexo) {
        return clienteRepository.findBySexo(sexo);
    }

    @Override
    public Cliente actualizarCliente(UUID id, String apellidoPaterno, String apellidoMaterno,
                                     String nombres, String telefono, String sexo,
                                     LocalDateTime fechaNacimiento) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

        Cliente clienteActualizado = clienteExistente.actualizar(
                apellidoPaterno, apellidoMaterno, nombres,
                telefono, sexo, fechaNacimiento
        );

        return clienteRepository.save(clienteActualizado);
    }

    @Override
    public Cliente actualizarEstadoCliente(UUID id, Boolean activo) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

        Cliente clienteActualizado = clienteExistente.cambiarEstado(activo);

        return clienteRepository.save(clienteActualizado);
    }

    @Override
    public void eliminarCliente(UUID id) {
        if (!clienteRepository.findById(id).isPresent()) {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
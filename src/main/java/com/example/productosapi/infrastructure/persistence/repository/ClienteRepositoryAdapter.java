package com.example.productosapi.infrastructure.persistence.repository;

import com.example.productosapi.domain.model.Cliente;
import com.example.productosapi.domain.repository.ClienteRepository;
import com.example.productosapi.infrastructure.persistence.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteJpaRepository jpaRepository;
    private final ClienteMapper mapper;

    @Override
    public Cliente save(Cliente cliente) {
        var entity = mapper.toEntity(cliente);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cliente> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Cliente> findByNumeroDni(String numeroDni) {
        return jpaRepository.findByNumeroDni(numeroDni)
                .map(mapper::toDomain);
    }

    @Override
    public List<Cliente> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> findByActivo(Boolean activo) {
        return jpaRepository.findByActivo(activo).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> findBySexo(String sexo) {
        return jpaRepository.findBySexo(sexo).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByNumeroDni(String numeroDni) {
        return jpaRepository.existsByNumeroDni(numeroDni);
    }
}
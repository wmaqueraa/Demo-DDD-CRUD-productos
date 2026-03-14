package com.example.productosapi.domain.exception;

import java.util.UUID;

public class ClienteNotFoundException extends BusinessException{
    public ClienteNotFoundException(UUID id) {
        super("No se encontró el cliente con ID: " + id);
    }

    public ClienteNotFoundException(String numeroDni) {
        super("No se encontró el cliente con numero de DNI: " + numeroDni);
    }
}

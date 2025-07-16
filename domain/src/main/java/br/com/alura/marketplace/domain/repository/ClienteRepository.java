package br.com.alura.marketplace.domain.repository;

import br.com.alura.marketplace.domain.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository {

    Optional<Cliente> findByNumeroDocumento(String numeroDocumento);
}

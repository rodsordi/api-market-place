package br.com.alura.marketplace.infra.repository;

import br.com.alura.marketplace.domain.entity.Cliente;
import br.com.alura.marketplace.domain.repository.ClienteRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public class ClienteRepositoryImpl implements ClienteRepository {

    @Override
    public Optional<Cliente> findByNumeroDocumento(String numeroDocumento) {
        return Optional.empty();
    }
}

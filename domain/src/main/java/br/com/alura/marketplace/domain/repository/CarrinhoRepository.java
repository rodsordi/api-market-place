package br.com.alura.marketplace.domain.repository;

import br.com.alura.marketplace.domain.entity.Carrinho;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarrinhoRepository extends CrudRepository<Carrinho, UUID> {

    Page<Carrinho> findByClienteId(UUID clienteId);
}

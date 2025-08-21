package br.com.alura.marketplace.domain.repository;

import br.com.alura.marketplace.domain.entity.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProdutoRepository extends CrudRepository<Produto, UUID> {

}

package br.com.alura.marketplace.infra.repository;

import br.com.alura.marketplace.domain.repository.ProdutoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface ProdutoRepositoryExt extends ProdutoRepository {

}

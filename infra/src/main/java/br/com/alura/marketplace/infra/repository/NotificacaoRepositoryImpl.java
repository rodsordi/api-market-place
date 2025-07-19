package br.com.alura.marketplace.infra.repository;

import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.domain.repository.NotificacaoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class NotificacaoRepositoryImpl implements NotificacaoRepository {

    @Override
    public void notificar(Produto produto) {

    }
}

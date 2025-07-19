package br.com.alura.marketplace.domain.repository;

import br.com.alura.marketplace.domain.entity.Produto;

public interface NotificacaoRepository {

    void notificar(Produto produto);
}

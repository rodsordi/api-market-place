package br.com.alura.marketplace.domain.repository;

import br.com.alura.marketplace.domain.entity.Carrinho;

public interface NotificacaoRepository {

    void notificar(Carrinho carrinho);
}

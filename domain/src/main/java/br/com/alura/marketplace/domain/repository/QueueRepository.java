package br.com.alura.marketplace.domain.repository;

import br.com.alura.marketplace.domain.entity.Produto;

public interface QueueRepository {

    void notificarCadastro(Produto produto);
}

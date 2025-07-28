package br.com.alura.marketplace.domain.repository;

import br.com.alura.marketplace.domain.entity.Foto;

public interface BucketRepository {

    Foto armazenar(Foto foto);
}

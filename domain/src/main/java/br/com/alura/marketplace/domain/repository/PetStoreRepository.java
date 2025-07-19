package br.com.alura.marketplace.domain.repository;

import br.com.alura.marketplace.domain.entity.Pet;

import java.util.Optional;

public interface PetStoreRepository {

    Optional<Pet> consultarPetPorNome(String nome);
}

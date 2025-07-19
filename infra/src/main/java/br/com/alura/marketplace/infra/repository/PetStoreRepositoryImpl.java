package br.com.alura.marketplace.infra.repository;

import br.com.alura.marketplace.domain.entity.Pet;
import br.com.alura.marketplace.infra.client.PetApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
public class PetStoreRepositoryImpl implements br.com.alura.marketplace.domain.repository.PetStoreRepository {

    private final PetApiClient petApiClient;

    @Override
    public Optional<Pet> consultarPetPorNome(String nome) {
        try {
            var response = petApiClient.
        }
    }
}

package br.com.alura.marketplace.domain.entity.factory;

import br.com.alura.marketplace.domain.entity.Pet;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static br.com.alura.marketplace.domain.entity.Pet.Status.AVAILABLE;
import static br.com.alura.marketplace.domain.util.DateUtil.newDateTime;
import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public final class PetFactory {

    private final Pet.PetBuilder builder;

    public static PetFactory criarPet() {
        return new PetFactory(Pet.builder());
    }

    public Pet comTodosOsCampos() {
        return builder
                .petId(UUID.fromString("0c3956b6-8db3-43a6-ae63-7f3ccdbd7151"))
                .nome("Pet 1")
                .categoria("Categoria 1")
                .urlFoto("https://example.com/foto1.jpg")
                .tag("Tag 1")
                .status(AVAILABLE)
                .criadoEm(newDateTime("21/12/2025 23:59:59"))
                .atualizadoEm(newDateTime("22/12/2025 23:59:59"))
                .build();
    }
}
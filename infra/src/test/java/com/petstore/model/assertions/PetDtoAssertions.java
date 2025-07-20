package com.petstore.model.assertions;

import com.petstore.model.PetDto;
import lombok.RequiredArgsConstructor;

import static com.petstore.model.PetDto.StatusEnum.AVAILABLE;
import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@RequiredArgsConstructor(access = PRIVATE)
public final class PetDtoAssertions {

    private final PetDto atual;

    public static PetDtoAssertions afirmaQue_PetDto(PetDto atual) {
        return new PetDtoAssertions(atual);
    }

    /**
     * @see br.com.alura.marketplace.domain.entity.factory.ProdutoFactory
     * .comTodosOsCampos()
     */
    public void foiConvertidoDe_Produto() {
        assertThat(atual.getId())
                .isNull();
        assertThat(atual.getName())
                .isEqualTo("Produto 1");
        assertThat(atual.getCategory())
                .isNotNull()
                .extracting("id", "name")
                .contains(null, "Categoria 1");
        assertThat(atual.getPhotoUrls())
                .hasSize(1)
                .contains("https://example.com/foto1.jpg");
        assertThat(atual.getTags())
                .hasSize(1)
                .extracting("id", "name")
                .containsExactlyInAnyOrder(
                        tuple(null, "Tag 1")
                );
        assertThat(atual.getStatus())
                .isEqualTo(AVAILABLE);
    }
}
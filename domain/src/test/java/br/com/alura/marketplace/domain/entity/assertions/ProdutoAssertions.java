package br.com.alura.marketplace.domain.entity.assertions;

import br.com.alura.marketplace.domain.entity.Produto;
import lombok.RequiredArgsConstructor;

import static br.com.alura.marketplace.domain.entity.Produto.Status.AVAILABLE;
import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor(access = PRIVATE)
public final class ProdutoAssertions {

    private final Produto atual;

    public static ProdutoAssertions afirmaQue_Produto(Produto atual) {
        return new ProdutoAssertions(atual);
    }

    /**
     * @see com.petstore.model.factory.PetDtoFactory
     * .comTodosOsCampos()
     */
    public void foiConvertidoDe_PetDto() {
        assertThat(atual.getProdutoId())
                .isNull();
        assertThat(atual.getNome())
                .isEqualTo("Pet Name 1");
        assertThat(atual.getCategoria())
                .isEqualTo("Category 1");
        assertThat(atual.getUrlFotos())
                .hasSize(1)
                .contains("http://example.com/photo1.jpg");
        assertThat(atual.getTags())
                .hasSize(1)
                .containsExactly("Tag 1");
        assertThat(atual.getStatus())
                .isEqualTo(AVAILABLE);
        assertThat(atual.getDescricao())
                .isNull();
        assertThat(atual.getValor())
                .isNull();
        assertThat(atual.getPetStorePetId())
                .isEqualTo(1L);
        assertThat(atual.getCriadoEm())
                .isNull();
        assertThat(atual.getAtualizadoEm())
                .isNull();
    }
}
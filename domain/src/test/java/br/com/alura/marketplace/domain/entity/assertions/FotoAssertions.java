package br.com.alura.marketplace.domain.entity.assertions;

import br.com.alura.marketplace.domain.entity.Foto;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

@RequiredArgsConstructor(access = PRIVATE)
public final class FotoAssertions {

    private final Foto atual;

    public static FotoAssertions afirmaQue_Foto(Foto atual) {
        return new FotoAssertions(spy(atual));
    }

    /**
     * @see com.petstore.model.factory.PetDtoFactory
     * .comTodosOsCampos()
     */
    public void foiConvertidoDe_PetDto() {
        assertThat(atual.getFotoId())
                .isNull();
        assertThat(atual.getFileName())
                .isNull();
        assertThat(atual.getLink())
                .isEqualTo("https://example.com/photo1.jpg");
        assertThat(atual.getBase64())
                .isNull();
        assertThat(atual.getCriadoEm())
                .isNull();
        assertThat(atual.getAtualizadoEm())
                .isNull();
    }

    /**
     * @see br.com.alura.marketplace.application.v1.dto.FotoDtoFactory
     * .comTodosOsCampos()
     */
    public void foiConvertidoDe_ProdutoDto_Request() {
        assertThat(atual.getFotoId())
                .isNull();
        assertThat(atual.getFileName())
                .isEqualTo("file-name-1.jpg");
        assertThat(atual.getLink())
                .isNull();
        assertThat(atual.getBase64())
                .isEqualTo("Y29udGVudC0x");
        assertThat(atual.getCriadoEm())
                .isNull();
        assertThat(atual.getAtualizadoEm())
                .isNull();
    }
}
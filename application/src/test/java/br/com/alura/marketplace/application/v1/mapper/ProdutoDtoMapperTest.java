package br.com.alura.marketplace.application.v1.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static br.com.alura.marketplace.application.v1.dto.ProdutoDtoFactory.criarProdutoDtoRequest;
import static br.com.alura.marketplace.domain.entity.assertions.ProdutoAssertions.afirmaQue_Produto;
import static org.mapstruct.factory.Mappers.getMapper;

class ProdutoDtoMapperTest {

    ProdutoDtoMapper mapper = getMapper(ProdutoDtoMapper.class);

    @DisplayName("Quando converter ProdutoDto.Request")
    @Nested
    class Converter {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @DisplayName("Dado um ProdutoDto.Request com todos os campos")
            @Test
            void teste1() {
                // Dado
                var dto = criarProdutoDtoRequest()
                        .comTodosOsCampos();
                // Quando
                var atual = mapper.converter(dto);
                // Então
                afirmaQue_Produto(atual)
                        .foiConvertidoDe_ProdutoDto_Request();
            }
        }
    }
}
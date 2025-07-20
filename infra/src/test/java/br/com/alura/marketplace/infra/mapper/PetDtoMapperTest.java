package br.com.alura.marketplace.infra.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static br.com.alura.marketplace.domain.entity.assertions.ProdutoAssertions.afirmaQue_Produto;
import static br.com.alura.marketplace.domain.entity.factory.ProdutoFactory.criarProduto;
import static com.petstore.model.assertions.PetDtoAssertions.afirmaQue_PetDto;
import static com.petstore.model.factory.PetDtoFactory.criarPetDto;
import static org.mapstruct.factory.Mappers.getMapper;

class PetDtoMapperTest {

    private static final PetDtoMapper mapper = getMapper(PetDtoMapper.class);

    @DisplayName("Quando converter Produto para PetDto")
    @Nested
    class Convert1 {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @DisplayName("Dado um Produto com todos os campos")
            @Test
            void teste1() {
                // Dado
                var produto = criarProduto().comTodosOsCampos();
                // Quando
                var atual = mapper.convert(produto);
                // Então
                afirmaQue_PetDto(atual)
                        .foiConvertidoDe_Produto();
            }
        }
    }

    @DisplayName("Quando converter PetDto para Produto")
    @Nested
    class Convert2 {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @DisplayName("Dado um PetDto com todos os campos")
            @Test
            void teste1() {
                // Dado
                var petDto = criarPetDto().comTodosOsCampos();
                // Quando
                var atual = mapper.convert(petDto);
                // Então
                afirmaQue_Produto(atual)
                        .foiConvertidoDe_PetDto();
            }
        }
    }
}
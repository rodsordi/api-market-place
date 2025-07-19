package br.com.alura.marketplace.application.v1.dto;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ProdutoDtoFactory {

    public static Request criarProdutoDtoRequest() {
        return new Request(ProdutoDto.Request.builder());
    }

    @RequiredArgsConstructor(access = PRIVATE)
    public static final class Request {

        private final ProdutoDto.Request.RequestBuilder builder;

        public ProdutoDto.Request comTodosOsCampos() {
            return builder
                    .nome("Produto Teste")
                    .descricao("Descrição do Produto Teste")
                    .valor(new BigDecimal("1.99"))
                    .build();
        }
    }
}
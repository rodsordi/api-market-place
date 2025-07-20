package br.com.alura.marketplace.application.v1.dto;

import br.com.alura.marketplace.application.v1.def.ProdutoDef;
import br.com.alura.marketplace.application.v1.mapper.ProdutoDtoMapper;
import br.com.alura.marketplace.domain.entity.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;
import static org.mapstruct.factory.Mappers.getMapper;

@NoArgsConstructor(access = PRIVATE)
public final class ProdutoDto {

    public static final ProdutoDtoMapper mapper = getMapper(ProdutoDtoMapper.class);

    @Getter
    @Builder
    public static class Request implements ProdutoDef.Request {

        private String nome;
        private String categoria;
        private Produto.Status status;
        private String descricao;
        private BigDecimal valor;
        List<String> urlFotos;
        private List<String> tags;

        public Produto buildProduto() {
            return mapper.converter(this);
        }
    }

    @Getter
    @Builder
    public static class Response implements ProdutoDef.Response {

        private UUID produtoId;
        private String nome;
        private String categoria;
        private Produto.Status status;
        private String descricao;
        private BigDecimal valor;
        private Long petStorePetId;
        private LocalDateTime criadoEm;
        private LocalDateTime atualizadoEm;

        public static Response buildProdutoDtoResponse(Produto produto) {
            return mapper.converter(produto);
        }
    }

    @Getter
    @Builder
    public static class Representacao implements ProdutoDef.Representacao {

        private UUID produtoId;
        private String nome;
        private String categoria;
        private Produto.Status status;
        private BigDecimal valor;
        private LocalDateTime criadoEm;
        private LocalDateTime atualizadoEm;

        public static Representacao buildProdutoDtoRepresentacao(Produto produto) {
            return mapper.converterParaRepresentacao(produto);
        }
    }
}

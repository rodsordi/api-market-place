package br.com.alura.marketplace.application.v1.dto;

import br.com.alura.marketplace.application.v1.def.CarrinhoDef;
import br.com.alura.marketplace.application.v1.mapper.CarrinhoDtoMapper;
import br.com.alura.marketplace.domain.entity.Carrinho;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.mapstruct.factory.Mappers.getMapper;

@NoArgsConstructor(access = PRIVATE)
public final class CarrinhoDto {

    private static final CarrinhoDtoMapper mapper = getMapper(CarrinhoDtoMapper.class);

    @Getter
    @Builder
    public static class Request implements CarrinhoDef.Request {

        private String clienteId;
        private List<ProdutoDto.Representacao> produtos;

        public Carrinho buildCarrinho() {
            return mapper.converter(this);
        }
    }

    @Getter
    @Builder
    public static class Response implements CarrinhoDef.Response {

        private String carrinhoId;
        private String clienteId;
        private Carrinho.Status status;
        private String valorTotal;
        private String criadoEm;
        private String atualizadoEm;
        private List<ProdutoDto.Response> produtos;

        public static Response buildCarrinhoDtoResponse(Carrinho carrinho) {
            return mapper.converter(carrinho);
        }
    }

    @Getter
    @Builder
    public static class Representacao implements CarrinhoDef.Representacao {

        private String carrinhoId;
        private String clienteId;
        private Carrinho.Status status;
        private String valorTotal;
        private String criadoEm;
        private String atualizadoEm;

        public static Representacao buildCarrinhoDtoRepresentacao(Carrinho carrinho) {
            return mapper.converterParaRepresentacao(carrinho);
        }
    }
}

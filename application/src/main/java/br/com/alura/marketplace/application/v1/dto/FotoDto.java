package br.com.alura.marketplace.application.v1.dto;

import br.com.alura.marketplace.application.v1.def.FotoDef;
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
public final class FotoDto {

    public static final ProdutoDtoMapper mapper = getMapper(ProdutoDtoMapper.class);

    @Getter
    @Builder
    public static class Request implements FotoDef.Request {

        private String fileName;
        private String base64;
    }

    @Getter
    @Builder
    public static class Response implements FotoDef.Response {

        private Long fotoId;
        private String fileName;
        private String link;
        private LocalDateTime criadoEm;
        private LocalDateTime atualizadoEm;
    }

    @Getter
    @Builder
    public static class Representacao implements FotoDef.Representacao {

        private Long fotoId;
        private String fileName;
        private String link;
        private LocalDateTime criadoEm;
        private LocalDateTime atualizadoEm;
    }
}

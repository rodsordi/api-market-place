package br.com.alura.marketplace.infra.msg;

import br.com.alura.marketplace.infra.def.FotoDef;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FotoMsg implements FotoDef.Response {

    private Long fotoId;
    private String fileName;
    private String link;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}

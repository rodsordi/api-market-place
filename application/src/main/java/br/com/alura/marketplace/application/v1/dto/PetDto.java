package br.com.alura.marketplace.application.v1.dto;

import br.com.alura.marketplace.application.v1.def.PetDef;
import br.com.alura.marketplace.domain.entity.Pet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PetDto {

    @Getter
    @Builder
    public static class Request implements PetDef.Request {

        private String nome;
    }

    @Getter
    @Builder
    public static class Response implements PetDef.Response {

        private UUID petId;
        private String nome;
        private String categoria;
        private Pet.Status status;
        private List<String> urlFotos;
        private List<String> tags;
        private LocalDateTime criadoEm;
        private LocalDateTime atualizadoEm;
    }


    @Getter
    @Builder
    public static class Representacao implements PetDef.Representacao {

        private UUID petId;
        private String nome;
        private LocalDateTime criadoEm;
        private LocalDateTime atualizadoEm;
    }
}

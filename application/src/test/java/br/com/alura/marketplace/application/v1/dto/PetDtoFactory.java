package br.com.alura.marketplace.application.v1.dto;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PetDtoFactory {

    public static Request criarPetDtoRequest() {
        return new Request(PetDto.Request.builder());
    }

    @RequiredArgsConstructor(access = PRIVATE)
    public static final class Request {

        private final PetDto.Request.RequestBuilder builder;

        public PetDto.Request comTodosOsCampos() {
            return builder
                    .nome("Pet 1")
                    .build();
        }
    }
}
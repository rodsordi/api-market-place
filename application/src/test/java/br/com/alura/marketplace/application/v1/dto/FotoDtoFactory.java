package br.com.alura.marketplace.application.v1.dto;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class FotoDtoFactory {

    public static Request criarFotoDtoRequest() {
        return new Request(FotoDto.Request.builder());
    }

    @RequiredArgsConstructor(access = PRIVATE)
    public static final class Request {

        private final FotoDto.Request.RequestBuilder builder;

        public FotoDto.Request comTodosOsCampos() {
            return builder
                    .fileName("file-name-1.jpg")
                    .base64("Y29udGVudC0x")
                    .build();
        }
    }
}
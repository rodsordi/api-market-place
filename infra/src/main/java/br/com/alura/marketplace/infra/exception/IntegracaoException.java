package br.com.alura.marketplace.infra.exception;

import feign.FeignException;

public class IntegracaoException extends RuntimeException {

    public IntegracaoException(FeignException e) {
        super(String.format("Status: %s, %s", e.status(), e.getMessage()));
    }
}

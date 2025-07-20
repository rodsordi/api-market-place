package br.com.alura.marketplace.domain.exception;

public class ErroInternoException extends RuntimeException {

    public ErroInternoException() {
        super("Erro interno");
    }
}

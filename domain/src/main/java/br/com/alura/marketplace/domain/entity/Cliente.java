package br.com.alura.marketplace.domain.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@EqualsAndHashCode
public class Cliente {

    private UUID clienteId;

    private String nome;

    private LocalDate dataNascimento;

    private String numeroDocumento;

    private String endereco;

    private LocalDateTime criadoEm;

    private LocalDateTime atualizadoEm;
}

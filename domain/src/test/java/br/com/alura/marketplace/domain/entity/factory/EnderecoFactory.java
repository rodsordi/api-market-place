package br.com.alura.marketplace.domain.entity.factory;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static br.com.alura.marketplace.domain.entity.Endereco.UF.SP;
import static br.com.alura.marketplace.domain.util.DateUtil.newDateTime;
import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public final class EnderecoFactory {

    private final Endereco.EnderecoBuilder builder;

    public static EnderecoFactory criarEndereco() {
        return new EnderecoFactory(Endereco.builder());
    }

    public Endereco comTodosOsCampos() {
        builder
                .enderecoId(UUID.fromString("d8b694fb-d6c6-4d78-8007-99975b887aa6"))
                .descricao("descrição 1")
                .cep("010100")
                .rua("Rua xpto")
                .numero("1234")
                .complemento("complemento 123")
                .bairro("bairo 123")
                .cidade("Cidade 123")
                .uf(SP)
                .criadoEm(newDateTime("31/12/2025 23:59:59"))
                .atualizadoEm(newDateTime("31/12/2025 23:59:59"))
        ;
        return builder.build();
    }
}
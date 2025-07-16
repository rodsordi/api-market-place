package br.com.alura.marketplace.domain.entity.factory;

import br.com.alura.marketplace.domain.entity.Cliente;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static br.com.alura.marketplace.domain.entity.factory.EnderecoFactory.criarEndereco;
import static br.com.alura.marketplace.domain.entity.factory.UsuarioFactory.criarUsuario;
import static br.com.alura.marketplace.domain.util.DateUtil.newDate;
import static br.com.alura.marketplace.domain.util.DateUtil.newDateTime;
import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public final class ClienteFactory {

    private final Cliente.ClienteBuilder builder;

    public static ClienteFactory criarCliente() {
        return new ClienteFactory(Cliente.builder());
    }

    public Cliente comTodosOsCampos() {
        builder
                .clienteId(UUID.fromString("cdc0d29e-b005-4fba-a6fe-d9a71e316fba"))
                .nome("cliente 1")
                .dataNascimento(newDate("31/12/1990"))
                .numeroDocumento("12345678910")
                .usuario(criarUsuario().comTodosOsCampos())
                .endereco(criarEndereco().comTodosOsCampos())
                .criadoEm(newDateTime("31/12/2025 23:59:59"))
                .atualizadoEm(newDateTime("31/12/2025 23:59:59"))
        ;
        return builder.build();
    }
}
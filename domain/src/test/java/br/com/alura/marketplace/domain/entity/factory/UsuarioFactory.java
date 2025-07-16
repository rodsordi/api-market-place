package br.com.alura.marketplace.domain.entity.factory;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static br.com.alura.marketplace.domain.util.DateUtil.newDateTime;
import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public final class UsuarioFactory {

    private final Usuario.UsuarioBuilder builder;

    public static UsuarioFactory criarUsuario() {
        return new UsuarioFactory(Usuario.builder());
    }

    public Usuario comTodosOsCampos() {
        builder
                .usuarioId(UUID.fromString("66e6bc66-620f-4636-bdcb-cb38837a2eba"))
                .email("usuario@email.com")
                .senha("senha1234")
                .ultimoAcesso(newDateTime("31/12/2025 23:59:59"))
                .criadoEm(newDateTime("31/12/2025 23:59:59"))
                .atualizadoEm(newDateTime("31/12/2025 23:59:59"))
        ;
        return builder.build();
    }
}
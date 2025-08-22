package br.com.alura.marketplace.application.errado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CadastrarExemploUseCaseTest {

    ExemploComponenteNoLugarErrado.CadastrarExemploUseCase cadastrarExemploUseCase;

    ExemploComponenteNoLugarErrado.ExemploRepository exemploRepository = mock(ExemploComponenteNoLugarErrado.ExemploRepository.class);

    @BeforeEach
    void beforeEach() {
        cadastrarExemploUseCase = new ExemploComponenteNoLugarErrado.CadastrarExemploUseCase(exemploRepository);
    }

    @Test
    void teste1() {
        // Dado
        when(exemploRepository.save(any()))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
        // E
        var exemplo = ExemploComponenteNoLugarErrado.ExemploDto.builder()
                .nome("Nome 1")
                .descricao("Descricao 1")
                .build();
        // Quando
        var atual = cadastrarExemploUseCase.cadastrar(exemplo);
        // Então
        assertThat(atual)
                .isNotNull();
    }
}

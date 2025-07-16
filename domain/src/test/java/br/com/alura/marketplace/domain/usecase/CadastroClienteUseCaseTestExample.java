package br.com.alura.marketplace.domain.usecase;

import br.com.alura.marketplace.domain.exception.BusinessException;
import br.com.alura.marketplace.domain.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.alura.marketplace.domain.entity.factory.ClienteFactory.criarCliente;
import static br.com.alura.marketplace.domain.util.DateUtil.newDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class CadastroClienteUseCaseTestExample {

    @InjectMocks
    private CadastroClienteUseCase cadastroClienteUseCase;

    @Mock
    private ClienteRepository clienteRepository;

    @DisplayName("Quando criar um cliente")
    @Nested
    class Criar {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @BeforeEach
            void beforeEach() {
                when(clienteRepository.save(any()))
                        .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
            }

            @DisplayName("Dado um cliente com todos os campos")
            @Test
            void teste1() {
                //Dado
                var cliente = criarCliente()
                        .comTodosOsCampos();
                //Quando
                var atual = cadastroClienteUseCase.criar(cliente);
                //Então
                assertThat(atual.getNome())
                        .isEqualTo("cliente 1");
            }
        }

        @DisplayName("Então deve retornar mensage de erro")
        @Nested
        class Falha {

            @DisplayName("Dado um cliente menor de idade")
            @Test
            void teste1() {
                //Dado
                var cliente = criarCliente().comTodosOsCampos();
                setField(cliente, "dataNascimento", newDate("31/12/2020"));
                //Quando
                var atual = assertThrows(BusinessException.class,
                        () -> cadastroClienteUseCase.criar(cliente));
                //Então
                assertThat(atual)
                        .hasMessage("Cliente não pode ser menor de idade");
            }
        }
    }
}
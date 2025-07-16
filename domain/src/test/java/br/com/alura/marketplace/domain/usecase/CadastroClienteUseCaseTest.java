package br.com.alura.marketplace.domain.usecase;

import br.com.alura.marketplace.domain.entity.Cliente;
import br.com.alura.marketplace.domain.exception.BusinessException;
import br.com.alura.marketplace.domain.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static br.com.alura.marketplace.domain.entity.factory.ClienteFactory.criarCliente;
import static br.com.alura.marketplace.domain.util.DateUtil.newDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(MockitoExtension.class)
class CadastroClienteUseCaseTest {

    @InjectMocks
    private CadastroClienteUseCase cadastroClienteUseCase;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private IntegracaoExternaRepository integracaoExternaRepository;

    @Nested
    class Criar {

        @Nested
        class Sucesso {

            @BeforeEach
            void beforeEach() {
                when(clienteRepository.save(any()))
                        .thenAnswer(invocationOnMock -> {
                            Cliente cliente = invocationOnMock.getArgument(0);
                            setField(cliente, "clienteId", UUID.fromString("b5bd69d1-d8b0-446b-aa6a-d67901e7a270"));
                            return cliente;
                        });
            }

            @Test
            void deve_criar_cliente_quando_for_maior_de_idade() {
                //Dado
                var cliente = criarCliente().comTodosOsCampos();
                //Quando
                var atual = cadastroClienteUseCase.criar(cliente);
                //Então
                assertThat(atual.getClienteId())
                        .hasToString("b5bd69d1-d8b0-446b-aa6a-d67901e7a270");
            }
        }

        @Nested
        class Falha {

            @Test
            void testClienteMenorDeIdade() {
                //Dado
                var cliente = criarCliente().comTodosOsCampos();
                setField(cliente, "dataNascimento", newDate("31/12/2020"));
                try {
                    //Quando
                    cadastroClienteUseCase.criar(cliente);
                    fail();
                } catch (BusinessException e) {
                    //Então
                    assertThat(e)
                            .hasMessage("Cliente não pode ser menor de idade");
                }
            }
        }
    }
}
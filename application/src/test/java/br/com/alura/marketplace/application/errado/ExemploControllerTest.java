package br.com.alura.marketplace.application.errado;

import br.com.alura.marketplace.application.v1.config.RestControllerTestConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
@ActiveProfiles("test")
@SpringBootTest(classes = ExemploComponenteNoLugarErrado.ExemploController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = RestControllerTestConfig.class)
class ExemploControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ExemploComponenteNoLugarErrado.CadastrarExemploUseCase cadastrarExemploUseCase;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void teste1() throws Exception {
        // Dado
        when(cadastrarExemploUseCase.cadastrar(any()))
                .thenAnswer(invocationOnMock -> {
                    var exemplo = invocationOnMock.getArgument(0);
                    setField(exemplo, "id", UUID.fromString("c06de587-4b79-49e7-8c02-aa0aecfec574"));
                    return exemplo;
                });
        // E
        var exemplo = ExemploComponenteNoLugarErrado.ExemploDto.builder()
                .nome("Nome 1")
                .descricao("Descricao 1")
                .build();
        // Quando
        mockMvc.perform(post("/v1/exemplos")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .characterEncoding(UTF_8.name())
                        .content(objectMapper.writeValueAsString(exemplo)))
                // Então
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is("c06de587-4b79-49e7-8c02-aa0aecfec574")))
        ;
    }
}
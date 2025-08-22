package br.com.alura.marketplace.application.errado;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class ExemploComponenteNoLugarErrado {

    @RequiredArgsConstructor
    @RestController
    @RequestMapping(path = "/v1/exemplos")
    public static class ExemploController {

        private final CadastrarExemploUseCase cadastrarExemploUseCase;

        @PostMapping(
                consumes = APPLICATION_JSON_VALUE,
                produces = APPLICATION_JSON_VALUE)
        @ResponseStatus(CREATED)
        public ExemploDto cadastrarExemplo(
                @Valid
                @RequestBody
                ExemploDto requestBody) {
            return cadastrarExemploUseCase.cadastrar(requestBody);
        }
    }

    @Getter
    @Builder
    public static class ExemploDto {

        private UUID id;
        private String nome;
        private String descricao;
    }

    @RequiredArgsConstructor
    @Service
    public static class CadastrarExemploUseCase {

        private final ExemploRepository exemploRepository;

        public ExemploDto cadastrar(ExemploDto dto) {
            var exemplo = Exemplo.builder()
                    .nome(dto.nome)
                    .descricao(dto.descricao)
                    .build();

            var exemploSalvo = exemploRepository.save(exemplo);

            return ExemploDto.builder()
                    .id(exemploSalvo.id)
                    .nome(exemploSalvo.nome)
                    .descricao(exemploSalvo.descricao)
                    .build();
        }
    }

    @Repository
    public interface ExemploRepository extends CrudRepository<Exemplo, Long> {
    }

    @Getter
    @Builder
    @Entity
    @Table
    public static class Exemplo {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        UUID id;
        @Column
        String nome;
        @Column
        String descricao;
    }
}

package br.com.alura.marketplace.application.v1.controller;

import br.com.alura.marketplace.application.v1.dto.CarrinhoDto;
import br.com.alura.marketplace.domain.usecase.ConsultaCarrinhoUseCase;
import br.com.alura.marketplace.domain.usecase.CriacaoCarrinhoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static br.com.alura.marketplace.application.v1.dto.CarrinhoDto.Response.buildCarrinhoDtoResponse;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/carrinhos")
public class CarrinhoController {

    private final CriacaoCarrinhoUseCase criacaoCarrinhoUseCase;

    private final ConsultaCarrinhoUseCase consultaCarrinhoUseCase;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public CarrinhoDto.Response criarCarrinho(
            @Valid
            @RequestBody
            CarrinhoDto.Request requestBody) {
        var carrinho = requestBody.buildCarrinho();
        var carrinhoCriado = criacaoCarrinhoUseCase.criar(carrinho);
        return buildCarrinhoDtoResponse(carrinhoCriado);
    }
}

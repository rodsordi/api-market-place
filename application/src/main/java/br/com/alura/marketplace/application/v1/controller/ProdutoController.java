package br.com.alura.marketplace.application.v1.controller;

import br.com.alura.marketplace.application.v1.dto.ProdutoDto;
import br.com.alura.marketplace.domain.usecase.CadastroProdutoUseCase;
import br.com.alura.marketplace.domain.usecase.ConsultaProdutoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static br.com.alura.marketplace.application.v1.dto.ProdutoDto.Response.buildProdutoDtoResponse;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/produtos")
public class ProdutoController {

    private final CadastroProdutoUseCase cadastroCarrinhoUseCase;

    private final ConsultaProdutoUseCase consultaProdutoUseCase;

    @PostMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public ProdutoDto.Response cadastrarProduto(
            @Valid
            @RequestBody
            ProdutoDto.Request requestBody) {
        var produto = requestBody.buildProduto();
        var produtoCriado = cadastroCarrinhoUseCase.cadastrar(produto);
        return buildProdutoDtoResponse(produtoCriado);
    }
}

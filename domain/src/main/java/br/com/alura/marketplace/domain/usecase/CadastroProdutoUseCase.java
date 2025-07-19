package br.com.alura.marketplace.domain.usecase;

import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.alura.marketplace.domain.util.ValidationUtil.validate;

@RequiredArgsConstructor
@Service
public class CadastroProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    private final

    public Produto cadastrar(Produto produto) {
        validate(produto);



        return produtoRepository.save(produto);
    }
}

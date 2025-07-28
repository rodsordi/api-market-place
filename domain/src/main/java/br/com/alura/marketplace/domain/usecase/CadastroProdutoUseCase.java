package br.com.alura.marketplace.domain.usecase;

import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.domain.repository.BucketRepository;
import br.com.alura.marketplace.domain.repository.PetStoreRepository;
import br.com.alura.marketplace.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.alura.marketplace.domain.util.ValidationUtil.validate;

@RequiredArgsConstructor
@Service
public class CadastroProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    private final PetStoreRepository petStoreRepository;

    private final BucketRepository bucketRepository;

    public Produto cadastrar(Produto produto) {
        validate(produto);

        if (!produto.getFotos().isEmpty())
            produto.getFotos()
                    .forEach(bucketRepository::armazenar);

        var produtoPetCadastrado = petStoreRepository.cadastrarPet(produto);

        produto.atualizar(produtoPetCadastrado);

        return produtoRepository.save(produto);
    }
}

package br.com.alura.marketplace.domain.usecase;

import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.domain.exception.NotFoundException;
import br.com.alura.marketplace.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ConsultaProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public Produto consultarPorId(UUID id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Produto.class));
    }
}

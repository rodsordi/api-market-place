package br.com.alura.marketplace.domain.usecase;

import br.com.alura.marketplace.domain.entity.Carrinho;
import br.com.alura.marketplace.domain.repository.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.alura.marketplace.domain.util.ValidationUtil.validate;

@RequiredArgsConstructor
@Service
public class CriacaoCarrinhoUseCase {

    private final CarrinhoRepository carrinhoRepository;

    public Carrinho criar(Carrinho carrinho) {
        validate(carrinho);

        return carrinhoRepository.save(carrinho);
    }
}

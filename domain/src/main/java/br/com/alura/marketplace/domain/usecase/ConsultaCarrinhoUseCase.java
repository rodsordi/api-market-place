package br.com.alura.marketplace.domain.usecase;

import br.com.alura.marketplace.domain.entity.Carrinho;
import br.com.alura.marketplace.domain.exception.NotFoundException;
import br.com.alura.marketplace.domain.repository.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ConsultaCarrinhoUseCase {

    private final CarrinhoRepository carrinhoRepository;

    public Carrinho pesquisarPorId(UUID id) {
        return carrinhoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Carrinho.class));
    }

    public Page<Carrinho> pesquisarPorClienteId(UUID clienteId) {

        return carrinhoRepository.findByClienteId(clienteId);
    }
}

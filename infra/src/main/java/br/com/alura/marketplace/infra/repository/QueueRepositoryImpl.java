package br.com.alura.marketplace.infra.repository;

import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.domain.repository.QueueRepository;
import br.com.alura.marketplace.infra.mapper.ProdutoMsgMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import static org.mapstruct.factory.Mappers.getMapper;

@RequiredArgsConstructor
@Repository
@Primary
public class QueueRepositoryImpl implements QueueRepository {

    private final ProdutoMsgMapper mapper = getMapper(ProdutoMsgMapper.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${message.market-place.queue-exchange}")
    public String queueExchange;

    @Value("${message.cadastro-produto.routing-key}")
    public String routingKeyName;

    @Override
    public void notificarCadastro(Produto produto) {
        var msg = mapper.converter(produto);
        rabbitTemplate.convertAndSend(queueExchange, routingKeyName, msg);
    }
}

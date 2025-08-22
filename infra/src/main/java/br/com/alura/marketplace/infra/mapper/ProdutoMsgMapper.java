package br.com.alura.marketplace.infra.mapper;

import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.infra.msg.ProdutoMsg;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(nullValuePropertyMappingStrategy = IGNORE)
public interface ProdutoMsgMapper {

    ProdutoMsg converter(Produto source);
}

package br.com.alura.marketplace.application.v1.mapper;

import br.com.alura.marketplace.application.v1.dto.CarrinhoDto;
import br.com.alura.marketplace.domain.entity.Carrinho;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(nullValuePropertyMappingStrategy = IGNORE)
public interface CarrinhoDtoMapper {

    Carrinho converter(CarrinhoDto.Request source);

    CarrinhoDto.Response converter(Carrinho source);

    CarrinhoDto.Representacao converterParaRepresentacao(Carrinho source);
}

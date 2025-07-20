package br.com.alura.marketplace.infra.repository;

import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.infra.client.PetApiClient;
import br.com.alura.marketplace.infra.exception.IntegracaoException;
import br.com.alura.marketplace.infra.mapper.PetDtoMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import static org.mapstruct.factory.Mappers.getMapper;

@Repository
@Primary
@RequiredArgsConstructor
public class PetStoreRepositoryImpl implements br.com.alura.marketplace.domain.repository.PetStoreRepository {

    private static final PetDtoMapper petDtoMapper = getMapper(PetDtoMapper.class);

    private final PetApiClient petApiClient;

    @Override
    public Produto cadastrarPet(Produto produto) {
        try {
            var petDto = petDtoMapper.convert(produto);
            var response = petApiClient.addPet(petDto);
            if (response.getStatusCode().is2xxSuccessful())
                return petDtoMapper.convert(response.getBody());
            return null;
        } catch (FeignException e) {
            throw new IntegracaoException(e);
        }
    }
}

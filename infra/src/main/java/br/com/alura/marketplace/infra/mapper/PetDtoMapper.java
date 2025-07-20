package br.com.alura.marketplace.infra.mapper;

import br.com.alura.marketplace.domain.entity.Produto;
import br.com.alura.marketplace.infra.map.CategoryToStringMap;
import br.com.alura.marketplace.infra.map.StringToCategoryMap;
import br.com.alura.marketplace.infra.map.StringToTagMap;
import br.com.alura.marketplace.infra.map.TagToStringMap;
import com.petstore.model.CategoryDto;
import com.petstore.model.PetDto;
import com.petstore.model.TagDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(nullValuePropertyMappingStrategy = IGNORE)
public interface PetDtoMapper extends
        StringToCategoryMap,
        StringToTagMap,
        CategoryToStringMap,
        TagToStringMap {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "nome")
    @Mapping(target = "category", source = "categoria")
    @Mapping(target = "photoUrls", source = "urlFotos")
    PetDto convert(Produto source);

    @Mapping(target = "petStorePetId", source = "id")
    @Mapping(target = "nome", source = "name")
    @Mapping(target = "categoria", source = "category")
    @Mapping(target = "urlFotos", source = "photoUrls")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "descricao", ignore = true)
    @Mapping(target = "valor", ignore = true)
    Produto convert(PetDto source);
}

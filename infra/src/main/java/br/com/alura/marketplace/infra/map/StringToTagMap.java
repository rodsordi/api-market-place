package br.com.alura.marketplace.infra.map;

import com.petstore.model.TagDto;

public interface StringToTagMap {

    default TagDto mapStringToTag(String value) {
        if (value == null)
            return null;
        return new TagDto().name(value);
    }
}

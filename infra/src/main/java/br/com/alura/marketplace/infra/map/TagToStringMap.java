package br.com.alura.marketplace.infra.map;

import com.petstore.model.TagDto;

public interface TagToStringMap {

    default String mapTagToString(TagDto value) {
        if (value == null)
            return null;
        return value.getName();
    }
}

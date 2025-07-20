package br.com.alura.marketplace.infra.map;

import com.petstore.model.CategoryDto;

public interface StringToCategoryMap {

    default CategoryDto mapStringToCategory(String value) {
        if (value == null)
            return null;
        return new CategoryDto().name(value);
    }
}

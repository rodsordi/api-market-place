package br.com.alura.marketplace.infra.map;

import com.petstore.model.CategoryDto;

public interface CategoryToStringMap {

    default String mapCategoryToString(CategoryDto value) {
        if (value == null)
            return null;
        return value.getName();
    }
}

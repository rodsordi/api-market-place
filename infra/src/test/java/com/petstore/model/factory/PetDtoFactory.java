package com.petstore.model.factory;

import com.petstore.model.CategoryDto;
import com.petstore.model.PetDto;
import com.petstore.model.TagDto;
import lombok.RequiredArgsConstructor;

import static com.petstore.model.PetDto.StatusEnum.AVAILABLE;
import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
public final class PetDtoFactory {

    private final PetDto dto;

    public static PetDtoFactory criarPetDto() {
        return new PetDtoFactory(new PetDto());
    }

    public PetDto comTodosOsCampos() {
        return dto
                .id(1L)
                .name("Pet Name 1")
                .category(new CategoryDto().id(1L).name("Category 1"))
                .addPhotoUrlsItem("https://example.com/photo1.jpg")
                .addTagsItem(new TagDto().id(1L).name("Tag 1"))
                .status(AVAILABLE);
    }
}
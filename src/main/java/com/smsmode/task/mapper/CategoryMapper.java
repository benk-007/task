package com.smsmode.task.mapper;

import com.smsmode.task.model.CategoryModel;
import com.smsmode.task.resource.category.CategoryItemGetResource;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Slf4j
@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public abstract class CategoryMapper {

    public abstract CategoryItemGetResource modelToGetResource(CategoryModel categoryModel);
}

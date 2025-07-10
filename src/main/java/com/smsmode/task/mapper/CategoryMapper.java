package com.smsmode.task.mapper;

import com.smsmode.task.model.CategoryModel;
import com.smsmode.task.model.base.AbstractBaseModel;
import com.smsmode.task.resource.category.CategoryItemGetResource;
import com.smsmode.task.resource.common.AuditGetResource;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.*;

@Slf4j
@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public abstract class CategoryMapper {

    public abstract CategoryItemGetResource modelToGetResource(CategoryModel categoryModel);

    public abstract AuditGetResource modelToAuditResource(AbstractBaseModel baseModel);

    @AfterMapping
    public void afterModelToGetResource(CategoryModel categoryModel, @MappingTarget CategoryItemGetResource categoryItemGetResource) {
        categoryItemGetResource.setAudit(this.modelToAuditResource(categoryModel));
    }
}

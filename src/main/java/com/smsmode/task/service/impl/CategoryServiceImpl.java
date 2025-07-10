package com.smsmode.task.service.impl;

import com.smsmode.task.dao.service.CategoryDaoService;
import com.smsmode.task.dao.specification.CategorySpecification;
import com.smsmode.task.mapper.CategoryMapper;
import com.smsmode.task.model.CategoryModel;
import com.smsmode.task.resource.category.CategoryItemGetResource;
import com.smsmode.task.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryDaoService categoryDaoService;

    @Override
    public ResponseEntity<Page<CategoryItemGetResource>> retrieveAllByPage(String search, Pageable pageable) {
        Specification<CategoryModel> specification = CategorySpecification.withNameLike(search);
        Page<CategoryModel> categories = categoryDaoService.findAllBy(specification, pageable);
        return ResponseEntity.ok(categories.map(categoryMapper::modelToGetResource));
    }
}

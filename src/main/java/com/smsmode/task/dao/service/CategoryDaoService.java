package com.smsmode.task.dao.service;

import com.smsmode.task.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CategoryDaoService {
    CategoryModel findOneBy(Specification<CategoryModel> specification);

    Page<CategoryModel> findAllBy(Specification<CategoryModel> specification, Pageable pageable);
}

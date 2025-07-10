package com.smsmode.task.service;

import com.smsmode.task.resource.category.CategoryItemGetResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<Page<CategoryItemGetResource>> retrieveAllByPage(String search, Pageable pageable);

}

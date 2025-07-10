package com.smsmode.task.controller;

import com.smsmode.task.resource.category.CategoryItemGetResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequestMapping("/categories")
public interface CategoryController {
    @GetMapping
    ResponseEntity <Page<CategoryItemGetResource>> getAllCategories(
            @RequestParam(value = "search", required = false) String search,
            Pageable pageable
    );
}

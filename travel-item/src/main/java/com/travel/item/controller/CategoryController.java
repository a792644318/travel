package com.travel.item.controller;

import com.travel.item.pojo.Category;
import com.travel.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("travel")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("category")
    public ResponseEntity<List<Category>> queryCategories(){
        return ResponseEntity.ok(categoryService.queryCategory());
    }

}

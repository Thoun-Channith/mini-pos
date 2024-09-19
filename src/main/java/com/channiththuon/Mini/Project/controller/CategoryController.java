package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.mapper.CategoryMapper;
import com.channiththuon.Mini.Project.models.entity.Category;
import com.channiththuon.Mini.Project.models.request.CategoryRequest;
import com.channiththuon.Mini.Project.models.response.CategoryResponse;
import com.channiththuon.Mini.Project.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CategoryRequest request) {

        Category entity = categoryMapper.toEntity(request);
        Category created = categoryService.saveData(entity);
        CategoryResponse response = categoryMapper.toDTO(created);

        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Category getData = categoryService.getById(id);
        CategoryResponse response = categoryMapper.toDTO(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoryRequest request) {
        Category entity = categoryMapper.toEntity(request);
        Category updated = categoryService.updateData(id, entity);
        CategoryResponse response = categoryMapper.toDTO(updated);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/image/{id}")
    public ResponseEntity<?> createImage(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file", HttpStatus.BAD_REQUEST);
        }

        if (!file.getContentType().startsWith("image")) {
            return new ResponseEntity<>("Please select an image file",HttpStatus.BAD_REQUEST);
        }
        Category entity = categoryService.saveImage(id, file);
        CategoryResponse response = categoryMapper.toDTO(entity);
        return ResponseEntity.ok(response);
    }
}

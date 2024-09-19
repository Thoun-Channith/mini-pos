package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.exception.ResourceNotFoundException;
import com.channiththuon.Mini.Project.models.entity.Category;
import com.channiththuon.Mini.Project.repository.CategoryRepository;
import com.channiththuon.Mini.Project.service.CategoryService;
import com.channiththuon.Mini.Project.service.GenerateNewFilenameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final GenerateNewFilenameService generateNewFilenameService;

    @Value("${app.basePath}")
    private String basePath;

    @Override
    public Category getById(Long id) {
        return categoryRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
    }

    @Override
    public Category saveData(Category category) {
        Category parentEnttityCategory = new Category();
        parentEnttityCategory.setCategoryName(category.getCategoryName());
        parentEnttityCategory.setCategoryCode(category.getCategoryCode());

        if (category.getParent() != null && category.getParent().getId() != null) {
            parentEnttityCategory.setParent(category.getParent());
        }

        return categoryRepository.save(parentEnttityCategory);
    }

    @Override
    public Category updateData(Long id, Category category) {

        Category categoryEntity = getById(id);
        categoryEntity.setCategoryName(category.getCategoryName());
        categoryEntity.setCategoryCode(category.getCategoryCode());

        if(category.getParent() != null && category.getParent().getId() != null) {
            Category parentEntity = getById(category.getParent().getId());
            categoryEntity.setParent(parentEntity);
        }else {
            categoryEntity.setParent(null);
        }

        return categoryRepository.save(categoryEntity);
    }

    @Override
    public Category saveImage(Long id, MultipartFile file) throws IOException {
        String workingDirectory = System.getProperty("user.dir");

        // Generate a new filename using the generateNewFilenameService
        String newFilename = generateNewFilenameService.generateNewFilename(file.getOriginalFilename());

        // Combine working directory and base path with the new filename
        String fullPath = workingDirectory + basePath + File.separator + newFilename;

        File destinationFile = new File(fullPath);
        destinationFile.getParentFile().mkdirs();  // Create parent directories if they don't exist
        file.transferTo(destinationFile);  // Transfer file to the destination

        // Retrieve the category, update the image path, and save it
        Category saveImageCategory = getById(id);
        saveImageCategory.setImagePath(newFilename);  // Store only the new filename, not the full path

        return categoryRepository.save(saveImageCategory);
    }

}

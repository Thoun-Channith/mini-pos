package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.models.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CategoryService {
    Category getById(Long id);

    Category saveData(Category category);

    Category updateData(Long id, Category category);

    Category saveImage(Long id, MultipartFile file) throws IOException;

}

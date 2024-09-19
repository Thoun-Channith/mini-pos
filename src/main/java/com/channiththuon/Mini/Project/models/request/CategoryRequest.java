package com.channiththuon.Mini.Project.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class CategoryRequest {
    @NotBlank(message = "Category name is mandatory")
    @Length(max = 150, message = "Category name must be less than 150 characters")
    private String categoryName;

    @Length(max = 10, message = "Category code must be less than 10 characters" )
    private String categoryCode;

    private Long parentId;

    private String imagePath;
}

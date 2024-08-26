package com.channiththuon.Mini.Project.models.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class BrandRequest {
    @NotBlank(message = "Name is mandatory")
    @Length(min = 3, max = 150, message = "Name be between 3 and 150 characters")
    private String name;
}

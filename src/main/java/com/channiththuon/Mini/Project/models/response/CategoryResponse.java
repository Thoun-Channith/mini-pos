package com.channiththuon.Mini.Project.models.response;

import lombok.Data;
import java.util.List;

@Data
public class CategoryResponse {

    private Long id;

    private String categoryName;

    private String categoryCode;

    private Long parentId;

    private String imagePath;

    private List<CategoryResponse> children;

}

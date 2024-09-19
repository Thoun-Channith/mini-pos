package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.models.entity.Category;
import com.channiththuon.Mini.Project.models.request.CategoryRequest;
import com.channiththuon.Mini.Project.models.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "parent.id", source = "parentId")
    Category toEntity(CategoryRequest request);

    @Mapping(target = "parentId", source = "parent.id")
    CategoryResponse toDTO(Category category);

}

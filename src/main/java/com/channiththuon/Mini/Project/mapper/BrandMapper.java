package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.models.entity.Brand;
import com.channiththuon.Mini.Project.models.request.BrandRequest;
import com.channiththuon.Mini.Project.models.response.BrandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
	
	 Brand toEntity(BrandRequest request);

	 BrandResponse toDTO(Brand entity);
}

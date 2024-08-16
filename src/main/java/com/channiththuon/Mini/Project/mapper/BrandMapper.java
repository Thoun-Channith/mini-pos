package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.entity.Brand;
import com.channiththuon.Mini.Project.request.BrandRequest;
import com.channiththuon.Mini.Project.respone.BrandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
	
	 Brand toEntity(BrandRequest request);

	 BrandResponse toDTO(Brand entity);
}

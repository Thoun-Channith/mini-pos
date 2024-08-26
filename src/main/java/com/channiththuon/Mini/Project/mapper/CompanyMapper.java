package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.models.entity.Company;
import com.channiththuon.Mini.Project.models.request.CompanyRequest;
import com.channiththuon.Mini.Project.models.response.CompanyResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toEntity(CompanyRequest request);

    CompanyResponse toDTO(Company entity);

}

package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.models.entity.Supplier;
import com.channiththuon.Mini.Project.models.request.SupplierRequest;
import com.channiththuon.Mini.Project.models.response.SupplierResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier toEntity(SupplierRequest request);

    SupplierResponse toDTO(Supplier entity);
}

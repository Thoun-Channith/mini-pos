package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.models.entity.Customer;
import com.channiththuon.Mini.Project.models.request.CustomerRequest;
import com.channiththuon.Mini.Project.models.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequest request);

    CustomerResponse toDTO(Customer entity);
}


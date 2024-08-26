package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.models.entity.Customer;
import com.channiththuon.Mini.Project.models.request.CustomerRequest;
import com.channiththuon.Mini.Project.models.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    Customer getById(Long id);

    Customer saveData(CustomerRequest request);

    Customer updateData(Long id, CustomerRequest request);

    List<CustomerResponse> listAll();

    Customer deleteById(Long id);
}

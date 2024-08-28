package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.models.entity.Supplier;
import com.channiththuon.Mini.Project.models.request.SupplierRequest;
import com.channiththuon.Mini.Project.models.response.SupplierResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface SupplierService {

    Supplier getById(Long id);

    Supplier saveData(SupplierRequest supplierRequest);

    Supplier updateData(Long id, SupplierRequest request);

    List<SupplierResponse> listAll();

    Supplier deleteById(Long id);

    Page<SupplierResponse> getWithPagination(Map<String, String> params);
}

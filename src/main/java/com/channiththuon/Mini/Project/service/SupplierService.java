package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.models.entity.Supplier;
import com.channiththuon.Mini.Project.models.request.SupplierRequest;
import com.channiththuon.Mini.Project.models.response.SupplierResponse;

import java.util.List;

public interface SupplierService {

    Supplier getById(Long id);

    Supplier saveData(SupplierRequest supplierRequest);

    Supplier updateData(Long id, SupplierRequest request);

    List<SupplierResponse> listAll();

    Supplier deleteById(Long id);
}

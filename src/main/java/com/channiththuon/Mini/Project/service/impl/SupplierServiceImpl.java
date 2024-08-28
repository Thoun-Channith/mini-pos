package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.exception.ResourceNotFoundException;
import com.channiththuon.Mini.Project.mapper.SupplierMapper;
import com.channiththuon.Mini.Project.models.entity.Supplier;
import com.channiththuon.Mini.Project.models.request.SupplierRequest;
import com.channiththuon.Mini.Project.models.response.SupplierResponse;
import com.channiththuon.Mini.Project.repository.SupplierRepository;
import com.channiththuon.Mini.Project.service.SupplierService;
import com.channiththuon.Mini.Project.service.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Supplier getById(Long id) {
        return supplierRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier", id));
    }

    @Override
    public Supplier saveData(SupplierRequest supplierRequest) {
        Supplier supplier = supplierMapper.toEntity(supplierRequest);
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateData(Long id, SupplierRequest request) {
        Supplier existingSupplier = getById(id);
        existingSupplier.setSupplierLocalName(request.getSupplierLocalName());
        existingSupplier.setSupplierEngName(request.getSupplierEngName());
        existingSupplier.setSupplierEmail(request.getSupplierEmail());
        existingSupplier.setSupplierPhone(request.getSupplierPhone());
        existingSupplier.setSupplierAddress(request.getSupplierAddress());
        existingSupplier.setVatNumber(request.getVatNumber());

        return supplierRepository.save(existingSupplier);
    }

    @Override
    public List<SupplierResponse> listAll() {
        return supplierRepository.findAllByIsDeletedFalse()
                .stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Supplier deleteById(Long id) {
        Supplier supplier = getById(id);
        supplier.setDeleted(true);
        return supplierRepository.save(supplier);
    }

    @Override
    public Page<SupplierResponse> getWithPagination(Map<String, String> params) {
        int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
        if (params.containsKey(PageUtil.PAGE_LIMIT)) {
            pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }
        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        if (params.containsKey(PageUtil.PAGE_NUMBER)){
            pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }
        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
        return supplierRepository.findAllByIsDeletedFalse(pageable).map(supplierMapper::toDTO);
    }

}

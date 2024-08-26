package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.models.entity.Supplier;
import com.channiththuon.Mini.Project.models.request.SupplierRequest;
import com.channiththuon.Mini.Project.models.response.SupplierResponse;
import com.channiththuon.Mini.Project.service.SupplierService;
import com.channiththuon.Mini.Project.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierMapper supplierMapper;

    @PostMapping
    public ResponseEntity<SupplierResponse> saveData(@RequestBody SupplierRequest supplierRequest) {
        Supplier supplier = supplierService.saveData(supplierRequest);
        SupplierResponse response = supplierMapper.toDTO(supplier);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> getById(@PathVariable Long id) {
        Supplier supplier = supplierService.getById(id);
        SupplierResponse response = supplierMapper.toDTO(supplier);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> updateData(@PathVariable Long id, @RequestBody SupplierRequest supplierRequest) {
        Supplier supplier = supplierService.updateData(id, supplierRequest);
        SupplierResponse response = supplierMapper.toDTO(supplier);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAll() {
        List<SupplierResponse> responses = supplierService.listAll();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SupplierResponse> deleteById(@PathVariable Long id) {
        Supplier supplier = supplierService.deleteById(id);
        SupplierResponse response = supplierMapper.toDTO(supplier);
        return ResponseEntity.ok(response);
    }
}

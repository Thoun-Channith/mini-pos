package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.models.dto.PageDTO;
import com.channiththuon.Mini.Project.models.entity.Customer;
import com.channiththuon.Mini.Project.mapper.CustomerMapper;
import com.channiththuon.Mini.Project.models.request.CustomerRequest;
import com.channiththuon.Mini.Project.models.response.CustomerResponse;
import com.channiththuon.Mini.Project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<CustomerResponse> saveData(@RequestBody CustomerRequest request) {
        Customer customer = customerService.saveData(request);
        CustomerResponse response = customerMapper.toDTO(customer);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        CustomerResponse response = customerMapper.toDTO(customer);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateData(@PathVariable Long id, @RequestBody CustomerRequest request) {
        Customer customer = customerService.updateData(id, request);
        CustomerResponse response = customerMapper.toDTO(customer);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> listAll() {
        List<CustomerResponse> customers = customerService.listAll();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerResponse> deleteById(@PathVariable Long id) {
        Customer customer = customerService.deleteById(id);
        CustomerResponse response = customerMapper.toDTO(customer);
        return ResponseEntity.ok(response);
    }

    @GetMapping("pagination")
    public ResponseEntity<?> getWithPagination(Map<String, String> params) {
        Page<CustomerResponse> withPagination = customerService.getWithPagination(params);
        PageDTO pageDTO = new PageDTO(withPagination);
        return ResponseEntity.ok(pageDTO);
    }
}

package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.models.entity.Company;
import com.channiththuon.Mini.Project.mapper.CompanyMapper;
import com.channiththuon.Mini.Project.models.request.CompanyRequest;
import com.channiththuon.Mini.Project.models.response.CompanyResponse;
import com.channiththuon.Mini.Project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @PostMapping
    public ResponseEntity<CompanyResponse> saveData(@RequestBody CompanyRequest request) {
        Company savedCompany = companyService.saveData(request);
        CompanyResponse response = companyMapper.toDTO(savedCompany);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyResponse> getById(@PathVariable Long id) {
        Company company = companyService.getById(id);
        CompanyResponse response = companyMapper.toDTO(company);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<CompanyResponse> updateData(@PathVariable Long id, @RequestBody CompanyRequest request) {
        Company updatedCompany = companyService.updateData(id, request);
        CompanyResponse response = companyMapper.toDTO(updatedCompany);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAll() {
        List<CompanyResponse> responses = companyService.listAll();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CompanyResponse> delete(@PathVariable Long id) {
        Company deletedCompany = companyService.deleteById(id);
        CompanyResponse response = companyMapper.toDTO(deletedCompany);
        return ResponseEntity.ok(response);
    }
}

package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.models.entity.Company;
import com.channiththuon.Mini.Project.models.request.CompanyRequest;
import com.channiththuon.Mini.Project.models.response.CompanyResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface CompanyService {

    Company getById(Long id);

    Company saveData(CompanyRequest companyRequest);

    Company updateData(Long id, CompanyRequest request);

    List<CompanyResponse> listAll();

    Company deleteById(Long id);

    Page<CompanyResponse> getWithPagination(Map<String, String> params);

}

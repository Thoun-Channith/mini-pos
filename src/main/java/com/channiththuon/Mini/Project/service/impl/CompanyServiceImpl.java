package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.exception.ResourceNotFoundException;
import com.channiththuon.Mini.Project.mapper.CompanyMapper;
import com.channiththuon.Mini.Project.models.entity.Company;
import com.channiththuon.Mini.Project.models.request.CompanyRequest;
import com.channiththuon.Mini.Project.models.response.CompanyResponse;
import com.channiththuon.Mini.Project.repository.CompanyRepository;
import com.channiththuon.Mini.Project.service.CompanyService;
import com.channiththuon.Mini.Project.service.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public Company getById(Long id) {
        return companyRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company", id));
    }

    @Override
    public Company saveData(CompanyRequest request) {
        Company company = companyMapper.toEntity(request);
        return companyRepository.save(company);
    }

    @Override
    public Company updateData(Long id, CompanyRequest request) {
        Company existingCompany = getById(id);

        existingCompany.setCompanyName(request.getCompanyName());
        existingCompany.setCompanyLocalName(request.getCompanyLocalName());
        existingCompany.setCompanyEngName(request.getCompanyEngName());
        existingCompany.setCompanyEmail(request.getCompanyEmail());
        existingCompany.setCompanyPhone(request.getCompanyPhone());
        existingCompany.setCompanyAddress(request.getCompanyAddress());
        existingCompany.setVatNumber(request.getVatNumber());
        existingCompany.setImagePath(request.getImagePath());
        existingCompany.setImage(request.getImage());

        return companyRepository.save(existingCompany);
    }

    @Override
    public List<CompanyResponse> listAll() {
        return companyRepository.findAllByIsDeletedFalse()
                .stream()
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public Company deleteById(Long id) {
        Company byId = getById(id);
        byId.setDeleted(true);
        companyRepository.save(byId);
        return byId;
    }

    @Override
    public Page<CompanyResponse> getWithPagination(Map<String, String> params) {

        int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
        if (params.containsKey(PageUtil.PAGE_LIMIT)) {
            pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }

        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        if (params.containsKey(PageUtil.PAGE_NUMBER)){
            pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }

        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
        return companyRepository.findAllByIsDeletedFalse(pageable).map(companyMapper::toDTO);
    }
}

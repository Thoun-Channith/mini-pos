package com.channiththuon.Mini.Project.service;

import org.springframework.data.domain.Page;
import com.channiththuon.Mini.Project.models.entity.Brand;
import com.channiththuon.Mini.Project.models.response.BrandResponse;

import java.util.List;
import java.util.Map;

public interface BrandService {
    Brand saveData(Brand brand);
    Brand getById(Long id);
    Brand updateData(Long id, Brand update);

    List<BrandResponse> listAll();

    Brand deleteById(Long id);

    Page<BrandResponse> getWithPagination(Map<String, String> params);

}

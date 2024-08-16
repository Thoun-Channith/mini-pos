package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.entity.Brand;
import com.channiththuon.Mini.Project.respone.BrandResponse;

import java.util.List;

public interface BrandService {
    Brand saveData(Brand brand);
    Brand getById(Long id);
    Brand updateData(Long id, Brand update);

    List<BrandResponse> listAll();

    Brand deleteById(Long id);

}

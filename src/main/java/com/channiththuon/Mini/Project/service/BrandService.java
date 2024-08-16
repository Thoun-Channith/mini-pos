package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.entity.Brand;

public interface BrandService {
    Brand saveData(Brand brand);
    Brand getById(Long id);
}

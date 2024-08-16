package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.dto.BrandDTO;
import com.channiththuon.Mini.Project.entity.Brand;

public class BrandMapper {
    public static Brand toBrand(BrandDTO dto) {
        Brand brand = new Brand();
        brand.setName(dto.getName());
        return brand;
    }
}

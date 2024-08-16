package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.entity.Brand;
import com.channiththuon.Mini.Project.exception.ApiException;
import com.channiththuon.Mini.Project.repository.BrandRepository;
import com.channiththuon.Mini.Project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand saveData(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(
                        ()-> new ApiException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d not found", id)));
    }
}

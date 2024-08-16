package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.entity.Brand;
import com.channiththuon.Mini.Project.exception.ResourceNotFoundException;
import com.channiththuon.Mini.Project.mapper.BrandMapper;
import com.channiththuon.Mini.Project.repository.BrandRepository;
import com.channiththuon.Mini.Project.respone.BrandResponse;
import com.channiththuon.Mini.Project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandReposiory;

    @Autowired
    private BrandMapper itemBrandMapper;

    @Override
    public Brand saveData(Brand brand) {
        return brandReposiory.save(brand);
    }

    @Override
    public Brand getById(Long id) {
        return brandReposiory.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brands", id));
    }

    @Override
    public Brand updateData(Long id, Brand update) {
        Brand dataUpdate = getById(id);
        dataUpdate.setName(update.getName());

        return brandReposiory.save(dataUpdate);
    }

    @Override
    public List<BrandResponse> listAll() {
        return brandReposiory.findAll().stream().map(itemBrandMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Brand deleteById(Long id) {
        Brand byId = getById(id);
        brandReposiory.delete(byId);
        return byId;
    }
}

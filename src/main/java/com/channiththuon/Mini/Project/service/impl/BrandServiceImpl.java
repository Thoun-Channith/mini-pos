package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.models.entity.Brand;
import com.channiththuon.Mini.Project.exception.ResourceNotFoundException;
import com.channiththuon.Mini.Project.mapper.BrandMapper;
import com.channiththuon.Mini.Project.repository.BrandRepository;
import com.channiththuon.Mini.Project.models.response.BrandResponse;
import com.channiththuon.Mini.Project.service.BrandService;
import com.channiththuon.Mini.Project.service.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// Brand Service Implement
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper itemBrandMapper;

    @Override
    public Brand saveData(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(Long id) {
        return brandRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand", id));
    }


    @Override
    public Brand updateData(Long id, Brand update) {
        Brand dataUpdate = getById(id);
        dataUpdate.setName(update.getName());

        return brandRepository.save(dataUpdate);
    }

    @Override
    public List<BrandResponse> listAll() {
        return brandRepository.findAllByIsDeletedFalse()
                .stream()
                .map(itemBrandMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Brand deleteById(Long id) {
        Brand byId = getById(id);
        byId.setDeleted(true);
        brandRepository.save(byId);
        return byId;
    }

    @Override
    public Page<BrandResponse> getWithPagination(Map<String, String> params) {

        int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
        if (params.containsKey(PageUtil.PAGE_LIMIT)) {
            pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }

        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        if (params.containsKey(PageUtil.PAGE_NUMBER)) {
            pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }

        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
        return brandRepository.findAllByIsDeletedFalse(pageable).map(itemBrandMapper::toDTO);
    }

}
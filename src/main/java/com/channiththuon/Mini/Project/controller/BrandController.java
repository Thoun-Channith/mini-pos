package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.models.dto.PageDTO;
import com.channiththuon.Mini.Project.models.entity.Brand;
import com.channiththuon.Mini.Project.mapper.BrandMapper;
import com.channiththuon.Mini.Project.models.request.BrandRequest;
import com.channiththuon.Mini.Project.models.response.BrandResponse;
import com.channiththuon.Mini.Project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandMapper brandMapper;

    @PostMapping
    public ResponseEntity<?> saveData(@RequestBody BrandRequest dto) {
        Brand brand = brandMapper.toEntity(dto);
        Brand saveData = brandService.saveData(brand);

        BrandResponse response = brandMapper.toDTO(saveData);

        return ResponseEntity.ok(response);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Brand brand = brandService.getById(id);
        return ResponseEntity.ok(brand);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateData(@PathVariable Long id, @RequestBody BrandRequest request) {

        Brand brand = brandMapper.toEntity(request);
        Brand update = brandService.updateData(id, brand);
        BrandResponse response = brandMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllEntity(){
        List<BrandResponse> responses = brandService.listAll();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Brand deleteById = brandService.deleteById(id);
        BrandResponse response = brandMapper.toDTO(deleteById);
        return ResponseEntity.ok(response);
    }

    @GetMapping("pagination")
    public ResponseEntity<?> getWithPagination(Map<String, String> params) {
        Page<BrandResponse> withPagination = brandService.getWithPagination(params);
        PageDTO pageDTO = new PageDTO(withPagination);
        return ResponseEntity.ok(pageDTO);
    }

}

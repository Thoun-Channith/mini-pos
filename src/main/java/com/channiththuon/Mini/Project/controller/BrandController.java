package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.entity.Brand;
import com.channiththuon.Mini.Project.mapper.BrandMapper;
import com.channiththuon.Mini.Project.request.BrandRequest;
import com.channiththuon.Mini.Project.respone.BrandResponse;
import com.channiththuon.Mini.Project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}

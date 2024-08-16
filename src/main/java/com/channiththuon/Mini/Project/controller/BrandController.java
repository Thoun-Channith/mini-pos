package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.dto.BrandDTO;
import com.channiththuon.Mini.Project.entity.Brand;
import com.channiththuon.Mini.Project.mapper.BrandMapper;
import com.channiththuon.Mini.Project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> saveData(@RequestBody BrandDTO dto) {
        Brand brand = BrandMapper.toBrand(dto);
        Brand saveData = brandService.saveData(brand);

        return ResponseEntity.ok(saveData);
    }

    @GetMapping({"{id}"})
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Brand brand = brandService.getById(id);
        return ResponseEntity.ok(brand);
    }
}

package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.models.entity.GeneralSetting;
import com.channiththuon.Mini.Project.models.request.GeneralSettingRequest;
import com.channiththuon.Mini.Project.models.response.GeneralSettingResponse;
import com.channiththuon.Mini.Project.service.GeneralSettingService;
import com.channiththuon.Mini.Project.mapper.GeneralSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("general-settings")
public class GeneralSettingController {

    @Autowired
    private GeneralSettingService generalSettingService;

    @Autowired
    private GeneralSettingMapper generalSettingMapper;

    @PostMapping
    public ResponseEntity<GeneralSettingResponse> saveData(@RequestBody GeneralSettingRequest request) {
        GeneralSetting generalSetting = generalSettingService.saveData(request);
        GeneralSettingResponse response = generalSettingMapper.toDTO(generalSetting);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralSettingResponse> getById(@PathVariable Long id) {
        GeneralSetting generalSetting = generalSettingService.getById(id);
        GeneralSettingResponse response = generalSettingMapper.toDTO(generalSetting);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralSettingResponse> updateData(@PathVariable Long id, @RequestBody GeneralSettingRequest request) {
        GeneralSetting generalSetting = generalSettingService.updateData(id, request);
        GeneralSettingResponse response = generalSettingMapper.toDTO(generalSetting);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<GeneralSettingResponse>> getAll() {
        List<GeneralSettingResponse> responses = generalSettingService.listAll();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralSettingResponse> deleteById(@PathVariable Long id) {
        GeneralSetting generalSetting = generalSettingService.deleteById(id);
        GeneralSettingResponse response = generalSettingMapper.toDTO(generalSetting);
        return ResponseEntity.ok(response);
    }
}

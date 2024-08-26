package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.exception.ResourceNotFoundException;
import com.channiththuon.Mini.Project.mapper.GeneralSettingMapper;
import com.channiththuon.Mini.Project.models.entity.GeneralSetting;
import com.channiththuon.Mini.Project.models.request.GeneralSettingRequest;
import com.channiththuon.Mini.Project.models.response.GeneralSettingResponse;
import com.channiththuon.Mini.Project.repository.GeneralSettingRepository;
import com.channiththuon.Mini.Project.service.GeneralSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralSettingServiceImpl implements GeneralSettingService {

    @Autowired
    private GeneralSettingRepository generalSettingRepository;

    @Autowired
    private GeneralSettingMapper generalSettingMapper;

    @Override
    public GeneralSetting saveData(GeneralSettingRequest generalSettingRequest) {
        GeneralSetting generalSetting = generalSettingMapper.toEntity(generalSettingRequest);
        return generalSettingRepository.save(generalSetting);
    }

    @Override
    public GeneralSetting getById(Long id) {
        return generalSettingRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("GeneralSetting", id));
    }

    @Override
    public GeneralSetting updateData(Long id, GeneralSettingRequest request) {
        GeneralSetting existing = getById(id);
        GeneralSetting updated = generalSettingMapper.toEntity(request);
        updated.setId(existing.getId()); // ensure the ID is preserved
        return generalSettingRepository.save(updated);
    }

    @Override
    public List<GeneralSettingResponse> listAll() {
        return generalSettingRepository.findAllByIsDeletedFalse()
                .stream()
                .map(generalSettingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GeneralSetting deleteById(Long id) {
        GeneralSetting generalSetting = getById(id);
        generalSetting.setDeleted(true);
        return generalSettingRepository.save(generalSetting);
    }
}

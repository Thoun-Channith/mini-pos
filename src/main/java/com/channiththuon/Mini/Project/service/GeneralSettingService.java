package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.models.entity.GeneralSetting;
import com.channiththuon.Mini.Project.models.request.GeneralSettingRequest;
import com.channiththuon.Mini.Project.models.response.GeneralSettingResponse;

import java.util.List;

public interface GeneralSettingService {

    GeneralSetting saveData(GeneralSettingRequest generalSettingRequest);

    GeneralSetting getById(Long id);

    GeneralSetting updateData(Long id, GeneralSettingRequest request);

    List<GeneralSettingResponse> listAll();

    GeneralSetting deleteById(Long id);
}

package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.models.entity.GeneralSetting;
import com.channiththuon.Mini.Project.models.request.GeneralSettingRequest;
import com.channiththuon.Mini.Project.models.response.GeneralSettingResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneralSettingMapper {

    GeneralSetting toEntity(GeneralSettingRequest request);

    GeneralSettingResponse toDTO(GeneralSetting entity);
}

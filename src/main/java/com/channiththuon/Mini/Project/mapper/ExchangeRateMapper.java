package com.channiththuon.Mini.Project.mapper;

import com.channiththuon.Mini.Project.models.entity.ExchangeRate;
import com.channiththuon.Mini.Project.models.request.ExchangeRateRequest;
import com.channiththuon.Mini.Project.models.response.ExchangeRateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {

    ExchangeRate toEntity(ExchangeRateRequest request);

    ExchangeRateResponse toDTO(ExchangeRate entity);

}

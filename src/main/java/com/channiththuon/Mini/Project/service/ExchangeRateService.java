package com.channiththuon.Mini.Project.service;

import com.channiththuon.Mini.Project.models.entity.ExchangeRate;
import com.channiththuon.Mini.Project.models.request.ExchangeRateRequest;
import com.channiththuon.Mini.Project.models.response.ExchangeRateResponse;

import java.util.List;

public interface ExchangeRateService {

    ExchangeRate getById(Long id);

    ExchangeRate saveData(ExchangeRateRequest request);

    ExchangeRate updateData(Long id, ExchangeRateRequest request);

    List<ExchangeRateResponse> listAll();

    ExchangeRate deleteById(Long id);
}

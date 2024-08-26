package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.exception.ResourceNotFoundException;
import com.channiththuon.Mini.Project.mapper.ExchangeRateMapper;
import com.channiththuon.Mini.Project.models.entity.ExchangeRate;
import com.channiththuon.Mini.Project.models.request.ExchangeRateRequest;
import com.channiththuon.Mini.Project.models.response.ExchangeRateResponse;
import com.channiththuon.Mini.Project.repository.ExchangeRateRepository;
import com.channiththuon.Mini.Project.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    private ExchangeRateMapper exchangeRateMapper;

    @Override
    public ExchangeRate getById(Long id) {
        return exchangeRateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ExchangeRate", id));
    }

    @Override
    public ExchangeRate saveData(ExchangeRateRequest request) {
        ExchangeRate exchangeRate = exchangeRateMapper.toEntity(request);
        return exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public ExchangeRate updateData(Long id, ExchangeRateRequest request) {
        ExchangeRate existingRate = getById(id);
        existingRate.setExchangeRate(request.getExchangeRate());
        return exchangeRateRepository.save(existingRate);
    }

    @Override
    public List<ExchangeRateResponse> listAll() {
        return exchangeRateRepository.findAllByIsDeletedFalse().stream()
                .map(exchangeRateMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExchangeRate deleteById(Long id) {
        ExchangeRate exchangeRate = getById(id);
        exchangeRate.setDeleted(true);
        return exchangeRateRepository.save(exchangeRate); // Save the updated entity
    }

}

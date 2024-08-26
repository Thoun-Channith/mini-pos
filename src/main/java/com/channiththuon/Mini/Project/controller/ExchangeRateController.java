package com.channiththuon.Mini.Project.controller;

import com.channiththuon.Mini.Project.mapper.ExchangeRateMapper;
import com.channiththuon.Mini.Project.models.entity.ExchangeRate;
import com.channiththuon.Mini.Project.models.request.ExchangeRateRequest;
import com.channiththuon.Mini.Project.models.response.ExchangeRateResponse;
import com.channiththuon.Mini.Project.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchange-rates")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private ExchangeRateMapper exchangeRateMapper;

    @PostMapping
    public ResponseEntity<ExchangeRateResponse> create(@RequestBody ExchangeRateRequest request) {
        ExchangeRate exchangeRate = exchangeRateService.saveData(request);
        ExchangeRateResponse response = exchangeRateMapper.toDTO(exchangeRate);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeRateResponse> getById(@PathVariable Long id) {
        ExchangeRate exchangeRate = exchangeRateService.getById(id);
        ExchangeRateResponse response = exchangeRateMapper.toDTO(exchangeRate);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExchangeRateResponse> update(@PathVariable Long id, @RequestBody ExchangeRateRequest request) {
        ExchangeRate updatedRate = exchangeRateService.updateData(id, request);
        ExchangeRateResponse response = exchangeRateMapper.toDTO(updatedRate);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ExchangeRateResponse>> listAll() {
        List<ExchangeRateResponse> responses = exchangeRateService.listAll();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExchangeRateResponse> delete(@PathVariable Long id) {
        ExchangeRate deletedRate = exchangeRateService.deleteById(id);
        ExchangeRateResponse response = exchangeRateMapper.toDTO(deletedRate);
        return ResponseEntity.ok(response);
    }
}

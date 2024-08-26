package com.channiththuon.Mini.Project.repository;

import com.channiththuon.Mini.Project.models.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    List<ExchangeRate> findAllByIsDeletedFalse();

    ExchangeRate findByIdAndIsDeletedFalse(Long id);

}

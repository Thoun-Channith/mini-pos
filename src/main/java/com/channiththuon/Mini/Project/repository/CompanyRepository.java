package com.channiththuon.Mini.Project.repository;

import com.channiththuon.Mini.Project.models.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByIdAndIsDeletedFalse(Long aLong);

    List<Company> findAllByIsDeletedFalse();

    Page<Company> findAllByIsDeletedFalse(Pageable pageable);
}

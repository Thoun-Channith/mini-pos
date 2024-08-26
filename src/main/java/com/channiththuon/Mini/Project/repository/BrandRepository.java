package com.channiththuon.Mini.Project.repository;

import com.channiththuon.Mini.Project.models.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findByIdAndIsDeletedFalse(Long id);

    List<Brand> findAllByIsDeletedFalse();

    Page<Brand> findAllByIsDeletedFalse(Pageable pageable);

}


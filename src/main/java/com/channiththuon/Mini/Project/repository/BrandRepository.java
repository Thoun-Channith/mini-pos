package com.channiththuon.Mini.Project.repository;

import com.channiththuon.Mini.Project.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}

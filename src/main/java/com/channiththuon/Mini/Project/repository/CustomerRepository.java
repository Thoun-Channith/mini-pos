package com.channiththuon.Mini.Project.repository;

import com.channiththuon.Mini.Project.models.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByIdAndIsDeletedFalse(Long id);
    List<Customer> findAllByIsDeletedFalse();
}

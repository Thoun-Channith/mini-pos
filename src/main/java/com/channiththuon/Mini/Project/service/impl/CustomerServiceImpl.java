package com.channiththuon.Mini.Project.service.impl;

import com.channiththuon.Mini.Project.mapper.CustomerMapper;
import com.channiththuon.Mini.Project.models.entity.Customer;
import com.channiththuon.Mini.Project.exception.ResourceNotFoundException;
import com.channiththuon.Mini.Project.models.request.CustomerRequest;
import com.channiththuon.Mini.Project.models.response.CustomerResponse;
import com.channiththuon.Mini.Project.repository.CustomerRepository;
import com.channiththuon.Mini.Project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer getById(Long id) {
        return customerRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", id));
    }

    @Override
    public Customer saveData(CustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateData(Long id, CustomerRequest request) {
        Customer existingCustomer = customerRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", id));

        existingCustomer.setCustomerLocalName(request.getCustomerLocalName());
        existingCustomer.setCustomerEngName(request.getCustomerEngName());
        existingCustomer.setCustomerEmail(request.getCustomerEmail());
        existingCustomer.setCustomerPhone(request.getCustomerPhone());
        existingCustomer.setCustomerAddress(request.getCustomerAddress());

        return customerRepository.save(existingCustomer);
    }


    @Override
    public List<CustomerResponse> listAll() {
        return customerRepository.findAllByIsDeletedFalse()
                .stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Customer deleteById(Long id) {
        Customer customer = getById(id);
        customer.setDeleted(true);
        return customerRepository.save(customer);
    }
}

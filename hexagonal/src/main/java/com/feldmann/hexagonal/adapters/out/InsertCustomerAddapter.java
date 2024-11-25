package com.feldmann.hexagonal.adapters.out;

import com.feldmann.hexagonal.adapters.out.repository.CustomerRepository;
import com.feldmann.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.feldmann.hexagonal.application.core.domain.Customer;
import com.feldmann.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAddapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
    customerRepository.save(customerEntity);
    }
}
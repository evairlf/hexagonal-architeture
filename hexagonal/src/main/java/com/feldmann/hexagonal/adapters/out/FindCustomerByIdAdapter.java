package com.feldmann.hexagonal.adapters.out;

import com.feldmann.hexagonal.adapters.out.repository.CustomerRepository;
import com.feldmann.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.feldmann.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.feldmann.hexagonal.application.core.domain.Customer;
import com.feldmann.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private  CustomerRepository customerRepository;

    private CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}

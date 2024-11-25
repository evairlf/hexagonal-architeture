package com.feldmann.hexagonal.application.ports.out;

import com.feldmann.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);

}
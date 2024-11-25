package com.feldmann.hexagonal.application.ports.out;

import com.feldmann.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);

}
package com.feldmann.hexagonal.application.ports.in;

import com.feldmann.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}

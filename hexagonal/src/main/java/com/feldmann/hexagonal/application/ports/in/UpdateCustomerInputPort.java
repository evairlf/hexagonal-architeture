package com.feldmann.hexagonal.application.ports.in;

import com.feldmann.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}

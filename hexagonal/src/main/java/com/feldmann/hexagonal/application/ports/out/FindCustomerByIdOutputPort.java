package com.feldmann.hexagonal.application.ports.out;

import com.feldmann.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);

}
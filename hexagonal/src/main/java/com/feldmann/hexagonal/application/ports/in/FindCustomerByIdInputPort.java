package com.feldmann.hexagonal.application.ports.in;

import com.feldmann.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}

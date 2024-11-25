package com.feldmann.hexagonal.application.core.usecase;

import com.feldmann.hexagonal.application.core.domain.Customer;
import com.feldmann.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.feldmann.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    public final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id){
               return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer Not Found"));
    }

}
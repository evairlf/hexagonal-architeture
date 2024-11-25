package com.feldmann.hexagonal.application.core.usecase;

import com.feldmann.hexagonal.application.core.domain.Customer;
import com.feldmann.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.feldmann.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.feldmann.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.feldmann.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }

}

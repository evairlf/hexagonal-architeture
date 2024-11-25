package com.feldmann.hexagonal.adapters.in.controller.mapper;

import com.feldmann.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.feldmann.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.feldmann.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T07:12:46-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        return customerResponse;
    }
}

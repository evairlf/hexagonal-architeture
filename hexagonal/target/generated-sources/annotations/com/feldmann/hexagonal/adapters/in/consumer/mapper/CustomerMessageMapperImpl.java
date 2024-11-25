package com.feldmann.hexagonal.adapters.in.consumer.mapper;

import com.feldmann.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.feldmann.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-25T07:12:46-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class CustomerMessageMapperImpl implements CustomerMessageMapper {

    @Override
    public Customer toCustomer(CustomerMessage customerMessage) {
        if ( customerMessage == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }
}

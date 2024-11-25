package com.feldmann.hexagonal.application.ports.out;

import com.feldmann.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipcode);

}

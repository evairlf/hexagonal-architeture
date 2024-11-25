package com.feldmann.hexagonal.adapters.out.client.mapper;

import com.feldmann.hexagonal.adapters.out.client.response.AddressReponse;
import com.feldmann.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddres(AddressReponse addressReponse);

}
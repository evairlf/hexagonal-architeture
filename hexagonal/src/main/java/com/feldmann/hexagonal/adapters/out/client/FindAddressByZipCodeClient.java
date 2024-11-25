package com.feldmann.hexagonal.adapters.out.client;

import com.feldmann.hexagonal.adapters.out.client.response.AddressReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url= "${feldmann.client.address.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressReponse find(@PathVariable("zipCode") String zipcode);

}

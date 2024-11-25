package com.feldmann.hexagonal.config;

import com.feldmann.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.feldmann.hexagonal.adapters.out.InsertCustomerAddapter;
import com.feldmann.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.feldmann.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
    SendCpfValidationAdapter sendCpfValidationAdapter,
    InsertCustomerAddapter insertCustomerAddapter){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAddapter,sendCpfValidationAdapter);
    }

}

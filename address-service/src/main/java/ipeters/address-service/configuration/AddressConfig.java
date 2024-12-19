package ipeters.address;

/* carlpeters created on 17/12/2024 inside the package - ipeters.webclient_demo_address_service.configuration */

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}

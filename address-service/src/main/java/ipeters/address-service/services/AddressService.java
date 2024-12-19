package ipeters.address;

/* carlpeters created on 17/12/2024 inside the package - ipeters.webclient_demo.services */

import ipeters.webclient_demo_address_service.entities.Address;
import ipeters.webclient_demo_address_service.repositories.AddressRepo;
import ipeters.webclient_demo_address_service.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper mapper;

    public AddressResponse findAddressByEmployeeId(int employeeId) {
        Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);

        AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);

        return addressResponse;
    }

    public List<Address> findAll() {
        return this.addressRepo.findAll();
    }
}

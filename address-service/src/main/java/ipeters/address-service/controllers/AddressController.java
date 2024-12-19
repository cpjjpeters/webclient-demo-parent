package ipeters.address;

/* carlpeters created on 17/12/2024 inside the package - ipeters.webclient_demo_address_service.controllers */

import ipeters.webclient_demo_address_service.entities.Address;
import ipeters.webclient_demo_address_service.response.AddressResponse;
import ipeters.webclient_demo_address_service.services.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/address-service")
@Slf4j
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) {
        AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }
    @GetMapping(value ={ "/all","/findall"})
    public List<Address> findAll() {
        log.debug("findAll addresses");
        return addressService.findAll();
//        http://localhost:8888/address-service/
    }
    @GetMapping(value = "/")
    public String showDefault(){
        log.debug("this is a long default debug message");
        return "default";
    }
}
package ipeters.employee_service.services;

import ipeters.employee_service.entities.Employee;
import ipeters.employee_service.repositories.EmployeeRepo;
import ipeters.employee_service.response.AddressResponse;
import ipeters.employee_service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private WebClient webClient;

    public EmployeeResponse getEmployeeById(int id) {

        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);

        // Using WebClient
        AddressResponse addressResponse = webClient.get().uri("/address/" + id).retrieve().bodyToMono(AddressResponse.class).block();
//        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }
}

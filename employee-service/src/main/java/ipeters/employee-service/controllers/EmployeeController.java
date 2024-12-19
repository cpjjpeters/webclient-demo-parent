package ipeters.employee-service.controllers;

import ipeters.webclient_demo.entities.Employee;
import ipeters.webclient_demo.response.EmployeeResponse;
import ipeters.webclient_demo.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("employee-service")
@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping(value = {"/all", "/findall"})
    public List<Employee> findAll() {
        log.debug("findAll employees");
        return employeeService.findAll();
    }

    @GetMapping(value = "/")
    public String showDefault() {
        log.debug("this is a long default debug message");
        return "default";
    }
}
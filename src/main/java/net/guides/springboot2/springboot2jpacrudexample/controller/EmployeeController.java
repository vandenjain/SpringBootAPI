package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
          
		return employee;
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
   
}

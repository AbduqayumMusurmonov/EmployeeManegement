package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee saveEmployee(Employee employee){
          return employeeRepository.save(employee);

    }

    public List<Employee> getAll(){
       List<Employee> result = employeeRepository.findAll();
       return result;

    }

    public Optional<Employee> getEmployeeById(Long id){
        Optional<Employee> result = employeeRepository.findById(id);
        return result;
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
}

package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

   @PostMapping("/postemployee")
   public ResponseEntity saveEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(employee1);
   }

    @GetMapping("/employeegetAll")
    public ResponseEntity getAll(){
        List<Employee> result = employeeService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Optional<Employee> result = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("deletById/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}

package com.employee.api.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.api.dao.EmployeeRepository;
import com.employee.api.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee ) {
		employeeRepository.save(employee);
		
		return "Employee Details saved Successfully;";
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee ) {
		Employee emp = employeeRepository.findById(employee.getId()).get();
		emp.setAddress(employee.getAddress());
		emp.setDob(employee.getDob());
		emp.setDept(employee.getDept());
		emp.setMobileNumber(employee.getMobileNumber());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		employeeRepository.save(emp);
		return "Employee Details updated Successfully;";
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{empId}")
	public Employee getEmployee(@PathVariable Integer empId){
		return employeeRepository.findById(empId).get();
	}
	
	@DeleteMapping("/{empId}")
	public String deleteEmployee(@PathVariable Integer empId){
		
		 employeeRepository.deleteById(empId);
		 return "Employee deleted successfully";
	}

}

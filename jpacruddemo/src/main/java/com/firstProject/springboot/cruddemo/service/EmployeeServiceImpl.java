package com.firstProject.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.firstProject.springboot.cruddemo.dao.EmployeeRepository;
import com.firstProject.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepo;

	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = empRepo.findById(theId);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return empRepo.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		empRepo.deleteById(theId);
	}

}

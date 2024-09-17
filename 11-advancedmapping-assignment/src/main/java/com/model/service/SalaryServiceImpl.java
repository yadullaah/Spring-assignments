package com.model.service;

import com.model.dto.SalaryDto;
import com.model.entity.Salary;
import com.model.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public SalaryDto addSalary(SalaryDto salaryDto) {
        Salary salary = convertToEntity(salaryDto);
        Salary savedSalary = salaryRepository.save(salary);
        return convertToDto(savedSalary);
    }

    @Override
    public SalaryDto updateSalary(SalaryDto salaryDto) {
        Salary salary = convertToEntity(salaryDto);
        Salary updatedSalary = salaryRepository.save(salary);
        return convertToDto(updatedSalary);
    }

    @Override
    public Optional<SalaryDto> getSalaryById(int salaryId) {
        return salaryRepository.findById(salaryId).map(this::convertToDto);
    }

    @Override
    public Page<SalaryDto> getAllSalaries(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return salaryRepository.findAll(pageable).map(this::convertToDto);
    }

    private Salary convertToEntity(SalaryDto salaryDto) {
        return new Salary(
                salaryDto.getSalaryId(),
                salaryDto.getSalaryMonth(),
                salaryDto.getGrossSalary(),
                salaryDto.getDeductions(),
                salaryDto.getNetSalary(),
                salaryDto.getPaymentDate(),
                salaryDto.getStatusSalary(), 
        );
    }

    private SalaryDto convertToDto(Salary salary) {
        return new SalaryDto(
                salary.getSalaryId(),
                salary.getSalaryMonth(),
                salary.getGrossSalary(),
                salary.getDeductions(),
                salary.getNetSalary(),
                salary.getPaymentDate(),
                salary.getStatusSalary()
        );
    }

	@Override
	public Optional<SalaryDto> getSalary(int salaryId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}

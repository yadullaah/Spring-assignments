package com.model.service;

import com.model.dto.SalaryDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface SalaryService {

    Page<SalaryDto> getAllSalaries(int pageNumber, int pageSize);

    SalaryDto addSalary(SalaryDto salaryDto);

    SalaryDto updateSalary(SalaryDto salaryDto);

    Optional<SalaryDto> getSalary(int salaryId);

	Optional<SalaryDto> getSalaryById(int salaryId);
}

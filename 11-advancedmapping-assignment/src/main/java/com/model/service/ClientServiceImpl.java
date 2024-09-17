package com.model.service;

import com.model.dto.ClientDto;
import com.model.dto.EmployeeDto;
import com.model.entity.Client;
import com.model.entity.Employee;
import com.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ClientDto addClient(ClientDto clientDto) {
		Client client = convertToEntity(clientDto);
		client = clientRepository.save(client);
		return convertToDto(client);
	}

	@Override
	public Optional<ClientDto> getClientById(int clientId) {
		Optional<Client> client = clientRepository.findById(clientId);
		return client.map(this::convertToDto);
	}

	@Override
	public Page<ClientDto> getAllClients(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return clientRepository.findAll(pageable).map(this::convertToDto);
	}

	@Override
	public ClientDto updateClient(ClientDto clientDto) {
		Client client = convertToEntity(clientDto);
		client = clientRepository.save(client);
		return convertToDto(client);
	}

	@Override
	public void deleteClient(int clientId) {
		clientRepository.deleteById(clientId);
	}

	// Conversion from DTO to Entity
	private Client convertToEntity(ClientDto clientDto) {
		Client client = new Client();
		client.setClientId(clientDto.getClientId());
		client.setCompanyName(clientDto.getCompanyName());
		client.setRegistrationNumber(clientDto.getRegistrationNumber());
		client.setContactPerson(clientDto.getContactPerson());
		client.setContactEmail(clientDto.getContactEmail());
		client.setContactNumber(clientDto.getContactNumber());
		client.setAddress(clientDto.getAddress());
		client.setStatus(clientDto.getStatus());
		client.setCreationDate(clientDto.getCreationDate());
		client.setKycStatus(clientDto.getKycStatus());

		// Convert list of EmployeeDto to Employee entities
		List<Employee> employees = new ArrayList<>();
		for (EmployeeDto employeeDto : clientDto.getEmployees()) {
			Employee employee = new Employee();
			employee.setEmployeeId(employeeDto.getEmployeeId());
			employee.setFirstName(employeeDto.getFirstName());
			employee.setLastName(employeeDto.getLastName());
			employee.setPhoneNumber(employeeDto.getPhoneNumber());
			employee.setEmail(employeeDto.getEmail());
			employee.setPosition(employeeDto.getPosition());
			employee.setHireDate(employeeDto.getHireDate());
			employee.setSalary(employeeDto.getSalary());
			employee.setAccountNumber(employeeDto.getAccountNumber());
			employee.setStatus(employeeDto.getStatus());
			employees.add(employee);
		}
		client.setEmployees(employees);

		return client;
	}

	// Conversion from Entity to DTO
	private ClientDto convertToDto(Client client) {
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for (Employee employee : client.getEmployees()) {
			EmployeeDto employeeDto = new EmployeeDto(employee.getEmployeeId(), employee.getFirstName(),
					employee.getLastName(), employee.getPhoneNumber(), employee.getEmail(), employee.getPosition(),
					employee.getHireDate(), employee.getSalary(), employee.getAccountNumber(), employee.getStatus(),
					employee.getClient().getClientId());
			employeeDtos.add(employeeDto);
		}

		return new ClientDto(client.getClientId(), client.getCompanyName(), client.getRegistrationNumber(),
				client.getContactPerson(), client.getContactEmail(), client.getContactNumber(), client.getAddress(),
				client.getStatus(), client.getCreationDate(), client.getKycStatus(), employeeDtos);
	}

}

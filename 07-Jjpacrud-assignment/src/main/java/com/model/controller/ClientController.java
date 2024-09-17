package com.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.entity.Client;
import com.model.service.ClientService;

@RestController
@RequestMapping("/clientapp")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/clients")
	public ResponseEntity<Page<Client>> getAllClients(@RequestParam(required = false) String companyName,
			@RequestParam int pageNumber, @RequestParam int pageSize) {

		if (companyName != null)
			return ResponseEntity.ok(clientService.getAllClientsPage(companyName, pageSize, pageNumber));

		return ResponseEntity.ok(clientService.getAllClients(pageNumber, pageSize));
	}

	@PostMapping("/clients")
	public String addClient(@RequestBody Client client) {
		ResponseEntity.ok(clientService.addClient(client));
		return "Client added";
	}

	@PutMapping("/clients")
	public String updateClient(@RequestBody Client client) {
		ResponseEntity.ok(clientService.updateClient(client));
		return "Client updated";
	}

	@GetMapping("/clients/{clientId}")
	public ResponseEntity<Optional<Client>> getClient(@PathVariable int clientId) {
		return ResponseEntity.ok(clientService.getClient(clientId));
	}

	@GetMapping("/clients-company/{companyName}")
	public ResponseEntity<Client> getClientsByCompanyName(@PathVariable String companyName) {
		return ResponseEntity.ok(clientService.findByCompanyName(companyName));
	}
}

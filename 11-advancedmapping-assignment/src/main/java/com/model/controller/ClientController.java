package com.model.controller;

import com.model.dto.ClientDto;
import com.model.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDto>> getAllClients(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return ResponseEntity.ok(clientService.getAllClients(pageNumber, pageSize));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Optional<ClientDto>> getClientById(@PathVariable int clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @PostMapping
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.addClient(clientDto));
    }

    @PutMapping
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.updateClient(clientDto));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable int clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }
}

package com.model.service;

import com.model.dto.ClientDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ClientService {
    ClientDto addClient(ClientDto clientDto);

    Optional<ClientDto> getClientById(int clientId);

    Page<ClientDto> getAllClients(int pageNumber, int pageSize);

    ClientDto updateClient(ClientDto clientDto);

    void deleteClient(int clientId);
}

package com.model.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import com.model.entity.Client;

public interface ClientService {

    Page<Client> getAllClients(int pageNumber, int pageSize);

    Client addClient(Client client);

    Client updateClient(Client client);

    Optional<Client> getClient(int clientId);

    Client findByCompanyName(String companyName);

    Page<Client> getAllClientsPage(String companyName, int pageSize, int pageNumber);
}

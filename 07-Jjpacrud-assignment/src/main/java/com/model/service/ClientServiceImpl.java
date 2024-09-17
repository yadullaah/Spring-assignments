package com.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.model.entity.Client;
import com.model.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepo;

    @Override
    public Page<Client> getAllClients(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return clientRepo.findAll(pageable);
    }

    @Override
    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Page<Client> getAllClientsPage(String companyName, int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return clientRepo.findByCompanyName(companyName, pageable);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Optional<Client> getClient(int clientId) {
        return clientRepo.findById(clientId);
    }

    @Override
    public Client findByCompanyName(String companyName) {
        return clientRepo.findByCompanyName(companyName);
    }
}

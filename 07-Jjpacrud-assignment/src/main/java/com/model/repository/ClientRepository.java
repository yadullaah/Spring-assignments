package com.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

   Client findByCompanyName(String companyName);

    Page<Client> findByCompanyName(String companyName, Pageable pageable);
}


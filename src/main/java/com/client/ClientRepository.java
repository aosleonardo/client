package com.client;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID>{

    List<Client> findAllByDocument(String document, Pageable page);
    List<Client> findAllByName(String name, Pageable page);
    List<Client> findAllByNameAndDocument(String name, String document, Pageable page);
}

package com.client;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity clientList(Pageable page, String name, String document) {
        List<Client> clients = getClients(page, name, document);

        if (!clients.isEmpty()) {
            return ResponseEntity.ok().body(clients);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity createdClient(Client client) {
        return ResponseEntity.ok().body(clientRepository.save(client));
    }

    public ResponseEntity updateClient(UUID id, Client client) {
        return clientRepository.findById(id)
                .map(record -> {
                    record.setName(client.getName());
                    record.setDocument(client.getDocument());
                    record.setBirthDate(client.getBirthDate());
                    Client updated = clientRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    private List<Client> getClients(Pageable page, String name, String document) {
        List<Client> clients = new ArrayList<>();
        if (StringUtils.isEmpty(document) && StringUtils.isEmpty(name)) {
            clients = clientRepository.findAll(page).getContent();
        }

        if (!StringUtils.isEmpty(document) && StringUtils.isEmpty(name)) {
            clients = clientRepository.findAllByDocument(document, page);
        }

        if (StringUtils.isEmpty(document) && !StringUtils.isEmpty(name)) {
            clients = clientRepository.findAllByName(name, page);
        }

        if (!StringUtils.isEmpty(document) && !StringUtils.isEmpty(name)) {
            clients = clientRepository.findAllByNameAndDocument(name, document, page);
        }
        return clients;
    }
}


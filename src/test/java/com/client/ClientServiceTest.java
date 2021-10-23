package com.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

public class ClientServiceTest {

    private ClientService clientService;
    private ClientRepository clientRepository;

    @BeforeEach
    public void setUp() {
        clientRepository = mock(ClientRepository.class);
        clientService = new ClientService(clientRepository);
    }

    @Test
    void getClientFindOneDocumentTest() {
        when(clientRepository.findAllByDocument(any(), any()))
                .thenReturn(ClientStub.create());

        ResponseEntity response = clientService.clientList(null, null, "08750454641");

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(((List<Client>) response.getBody()).size(), 1);
        assertEquals(((List<Client>) response.getBody()).get(0).getDocument(), "08750454641");
    }

    @Test
    void getClientFindOneNameTest() {
        when(clientRepository.findAllByName(any(), any()))
                .thenReturn(ClientStub.create());

        ResponseEntity response = clientService.clientList(null, "Leonardo Augusto", null);

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(((List<Client>) response.getBody()).size(), 1);
        assertEquals(((List<Client>) response.getBody()).get(0).getDocument(), "08750454641");
    }
}
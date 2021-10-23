package com.client;

import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientStub {
    public static List<Client> create() {
        List<Client> clients = new ArrayList<>();
        clients.add(
                Client.builder()
                        .birthDate(LocalDate.MAX)
                        .document("08750454641")
                        .name("Leonardo Augusto")
                        .build()
        );
        return clients;
    }


}

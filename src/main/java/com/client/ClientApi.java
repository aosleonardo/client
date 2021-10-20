package com.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
public class ClientApi {

	private final ClientService clientService;

	public ClientApi(ClientService clientService) {
		this.clientService = clientService;
	}

	
	@GetMapping
	@ApiOperation(
            value = "Apresenta as informações de Agi Investimento na Visão 360, para Correntistas e Não Correntistas.",
            notes = "Retorna as informações de Agi Investimento.",
            response = Client.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public void teste() {
		System.out.println("leo");
	}
	
	
	
}

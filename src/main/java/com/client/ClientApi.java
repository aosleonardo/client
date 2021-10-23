package com.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClientApi {

    private final ClientService clientService;

    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @ApiOperation(
            value = "Lista o cadastro de clientes",
            response = Client.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity clientList(
            @PageableDefault(sort = "name", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable page,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String document
    ) {
        return clientService.clientList(page, name, document);
    }

    @PostMapping
    @ApiOperation(
            value = "Cadastro de cliente",
            response = Client.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createdClient(@RequestBody @Valid Client client) {
        return clientService.createdClient(client);
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Alterar cliente",
            response = Client.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateClient(@RequestBody @Valid Client client,
                                       @PathVariable("id") @NotBlank(message = "Deve ser informado o id do cliente") UUID id) {
        return clientService.updateClient(id, client);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

}

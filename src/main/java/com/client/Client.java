package com.client;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
    @ApiModelProperty(value = "Identificador do cliente",required = true)
	private UUID id;
	
	@Column(name = "name", nullable = false)
	@ApiModelProperty(value = "Nome do cliente",required = true)
	private String name;
	
	@Column(name = "birth_date", nullable = false)
	@ApiModelProperty(value = "Data de aniversario do cliente",required = true)
	private LocalDate birthDate;
	
	@Column(name = "document", nullable = false, length = 500)
	@ApiModelProperty(value = "CPF docliente",required = true)
	private String document;
	
	
}

package com.client;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

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
	@NotBlank(message = "O campo nome deve ser informado")
	private String name;
	
	@Column(name = "birth_date", nullable = false)
	@ApiModelProperty(value = "Data de aniversario do cliente",required = true)
	@NotNull(message = "Informe a data de nascimento")
	@PastOrPresent(message = "Data de nascimento inválida")
	private LocalDate birthDate;
	
	@Column(name = "document", nullable = false, length = 11)
	@ApiModelProperty(value = "CPF docliente",required = true)
	@NotBlank(message = "O campo nome deve ser informado")
	@CPF (message = "CPF inválido")
	private String document;

	public static Builder builder() {
		return new Builder();
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public int getAge() {
		int age = 0;
		if (this.birthDate != null) {
			age = Period.between(this.birthDate, LocalDate.now()).getYears();
		}
		return age;
	}


	public static final class Builder {
		private Client client;

		private Builder() {
			client = new Client();
		}

		public Builder name(String name) {
			client.setName(name);
			return this;
		}

		public Builder birthDate(LocalDate birthDate) {
			client.setBirthDate(birthDate);
			return this;
		}

		public Builder document(String document) {
			client.setDocument(document);
			return this;
		}

		public Client build() {
			return client;
		}
	}
}

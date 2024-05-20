package com.ozeias.os.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.ozeias.os.domain.Tecnico;

import jakarta.validation.constraints.NotEmpty;

public class TecnicoDTO implements Serializable{
	public static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "O campo NOME é requerido!")
	private String nome;

	@CPF
	@NotEmpty(message = "O campo CPF é requerido!")
	private String cpf;
	@NotEmpty(message = "O campo TELEFONE é requerido!")
	private String telefone;

	public TecnicoDTO() {
		super();
	}

	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setid(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

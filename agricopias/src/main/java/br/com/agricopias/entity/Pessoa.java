package br.com.agricopias.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.agricopias.enums.TipoPessoa;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	
	private TipoPessoa tipo;
	
	@CPF
	private String cpf;
	
	private String rg;
	
	@CNPJ
	private String cnpj;
	
	private String ie;
	
	private List<String> telefones = new ArrayList<>();//refazer mapeamento
	
	private List<String> emails = new ArrayList<>();
	
	private List<Endereco> enderecos = new ArrayList<>();

	public Pessoa(Long id, String nome, TipoPessoa tipo, String cpf, String rg, String cnpj, String ie, List<String> emails) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.cpf = cpf;
		this.rg = rg;
		this.cnpj = cnpj;
		this.ie = ie;
		this.emails = emails;
	}

	public Pessoa(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}

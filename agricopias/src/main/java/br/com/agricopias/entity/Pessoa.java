package br.com.agricopias.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.agricopias.enums.TipoPessoa;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -7312256880475029040L;

	@Id
	@SequenceGenerator(name = "pessoa_gen", sequenceName = "pessoa_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_gen")
	private Long id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private TipoPessoa tipo;
	
	@CPF
	@Column(columnDefinition = "char(14)")
	private String cpf;
	
	@Column(length = 15)
	private String rg;
	
	@CNPJ
	@Column(columnDefinition = "char(19)")
	private String cnpj;
	
	@Column(length = 20)
	private String ie;
	
	@ElementCollection
	@CollectionTable(
		name = "pessoa_telefones", 
		joinColumns = @JoinColumn(name = "pessoa_id")
	)
	private List<String> telefones = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(
		name = "pessoa_emails", 
		joinColumns = @JoinColumn(name = "pessoa_id")
	)
	private List<String> emails = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(
		name = "pessoa_enderecos",
		joinColumns = @JoinColumn(name = "pessoa_id"),		
		uniqueConstraints = @UniqueConstraint(columnNames = {"pessoa_id", "tipo"})		
	)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@Column(nullable = false)
	private Boolean hidden = Boolean.FALSE;

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

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}

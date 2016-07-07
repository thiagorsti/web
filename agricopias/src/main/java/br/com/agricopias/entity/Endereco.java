
package br.com.agricopias.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.agricopias.enums.TipoEndereco;

@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = -5734239275092579985L;

	@Enumerated(EnumType.STRING)
	@Column(length = 15, nullable = false)
	private TipoEndereco tipo;
	
	@Column(length = 60, nullable = false)
	private String logradouro;
	
	private Integer numero;

	@Column(length = 60)
	private String complemento;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cidade cidade;

	@Column(length = 60, nullable = false)
	private String bairro;

	@Column(columnDefinition = "char(9)")
	private String cep;

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Endereco other = (Endereco) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
}

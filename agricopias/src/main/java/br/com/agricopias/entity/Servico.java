package br.com.agricopias.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.agricopias.enums.Unidade;

@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = -2382599820776217681L;

	@Id
	@SequenceGenerator(name = "servico_gen", sequenceName = "servico_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico_gen")
	private Long id;
	
	@Column(nullable = false)
	private Integer codigo;
	
	@Column(length = 60, nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private TipoServico tipoServico;
	
	@Column(nullable = false, scale = 5, precision = 2)
	private BigDecimal valor;

	@Column(nullable = false)
	private Boolean possuiAreaChapada;	
	
	@Column(scale = 5, precision = 2)
	private BigDecimal valorAreaChapada;	 
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Unidade unidade;
	
	@Column(nullable = false)
	private Boolean possuiIntervaloDimensoes;	
	
	@Column(name = "lado1_inicio", scale = 5, precision = 2)
	private BigDecimal lado1Inicio;	
	
	@Column(name = "lado1_fim", scale = 5, precision = 2)
	private BigDecimal lado1Fim;	
	
	@Column(name = "lado2_inicio", scale = 5, precision = 2)
	private BigDecimal lado2Inicio;	
	
	@Column(name= "lado2_fim", scale = 5, precision = 2)
	private BigDecimal lado2Fim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Boolean getPossuiAreaChapada() {
		return possuiAreaChapada;
	}

	public void setPossuiAreaChapada(Boolean possuiAreaChapada) {
		this.possuiAreaChapada = possuiAreaChapada;
	}

	public BigDecimal getValorAreaChapada() {
		return valorAreaChapada;
	}

	public void setValorAreaChapada(BigDecimal valorAreaChapada) {
		this.valorAreaChapada = valorAreaChapada;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Boolean getPossuiIntervaloDimensoes() {
		return possuiIntervaloDimensoes;
	}

	public void setPossuiIntervaloDimensoes(Boolean possuiIntervaloDimensoes) {
		this.possuiIntervaloDimensoes = possuiIntervaloDimensoes;
	}

	public BigDecimal getLado1Inicio() {
		return lado1Inicio;
	}

	public void setLado1Inicio(BigDecimal lado1Inicio) {
		this.lado1Inicio = lado1Inicio;
	}

	public BigDecimal getLado1Fim() {
		return lado1Fim;
	}

	public void setLado1Fim(BigDecimal lado1Fim) {
		this.lado1Fim = lado1Fim;
	}

	public BigDecimal getLado2Inicio() {
		return lado2Inicio;
	}

	public void setLado2Inicio(BigDecimal lado2Inicio) {
		this.lado2Inicio = lado2Inicio;
	}

	public BigDecimal getLado2Fim() {
		return lado2Fim;
	}

	public void setLado2Fim(BigDecimal lado2Fim) {
		this.lado2Fim = lado2Fim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Servico other = (Servico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}

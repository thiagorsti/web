package br.com.agricopias.entity;

import java.math.BigDecimal;

import br.com.agricopias.enums.Unidade;

public class Servico {

	private Long id;

	private Integer codigo;
	
	private String descricao;

	private TipoServico tipoServico;
	
	private BigDecimal valor;

	private Boolean possuiAreaChapada;
	
	private BigDecimal valorAreaChapada;	 
	
	private Unidade unidade;
	
	private Boolean possuiIntervaloDimensoes;	
	
	private BigDecimal lado1Inicio;	
	
	private BigDecimal lado1Fim;	
	
	private BigDecimal lado2Inicio;	
	
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
}

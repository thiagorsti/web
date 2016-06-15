package br.com.agricopias.entity;

import java.math.BigDecimal;

import br.com.agricopias.enums.Unidade;

public class Servico {

	private Long id;

	private Integer codigo;
	
	private String descricao;

	private TipoServico tipoServico;

	private Boolean possuiAreaChapada;
	 
	private BigDecimal valor;
	
	private BigDecimal valorAreaChapada;	 
	
	private Unidade unidade;	
	
	private Boolean possuiIntervaloDimensoes;	
	
	private BigDecimal alturaInicial;	
	
	private BigDecimal alturaFinal;	
	
	private BigDecimal larguraInicial;	
	
	private BigDecimal larguraFinal;
	
	public Servico(){}

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

	public Boolean getPossuiAreaChapada() {
		return possuiAreaChapada;
	}

	public void setPossuiAreaChapada(Boolean possuiAreaChapada) {
		this.possuiAreaChapada = possuiAreaChapada;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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

	public BigDecimal getAlturaInicial() {
		return alturaInicial;
	}

	public void setAlturaInicial(BigDecimal alturaInicial) {
		this.alturaInicial = alturaInicial;
	}

	public BigDecimal getAlturaFinal() {
		return alturaFinal;
	}

	public void setAlturaFinal(BigDecimal alturaFinal) {
		this.alturaFinal = alturaFinal;
	}

	public BigDecimal getLarguraInicial() {
		return larguraInicial;
	}

	public void setLarguraInicial(BigDecimal larguraInicial) {
		this.larguraInicial = larguraInicial;
	}

	public BigDecimal getLarguraFinal() {
		return larguraFinal;
	}

	public void setLarguraFinal(BigDecimal larguraFinal) {
		this.larguraFinal = larguraFinal;
	}	
}

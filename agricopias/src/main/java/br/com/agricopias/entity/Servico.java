package br.com.agricopias.entity;

public class Servico {

	private Long id;

	private String descricao;

	private TipoServico tipoServico;

	private Boolean possuiAreaChapada;
	
	public Servico(){}
	
	public Servico(Long id, String descricao, TipoServico tipoServico, Boolean possuiAreaChapada) {
		this.id = id;
		this.descricao = descricao;
		this.tipoServico = tipoServico;
		this.possuiAreaChapada = possuiAreaChapada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}

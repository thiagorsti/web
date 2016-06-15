package br.com.agricopias.enums;

public enum SituacaoRequisicao {
	
	PAGA("Paga"), 
	NAO_PAGA("Não paga");

	private final String descricao;

	private SituacaoRequisicao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}

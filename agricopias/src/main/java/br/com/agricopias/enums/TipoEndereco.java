
package br.com.agricopias.enums;

public enum TipoEndereco {
	
	RESIDENCIAL("Residencial"), 
	COMERCIAL("Comercial");

	private final String descricao;

	private TipoEndereco(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}

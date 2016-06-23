
package br.com.agricopias.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.agricopias.enums.helper.JSONEnumDeserializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = JSONEnumDeserializer.class)
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
	
	@JsonProperty("value")
	public String getValue() {
		return name();
	}
}

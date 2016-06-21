package br.com.agricopias.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.agricopias.enums.helper.JSONEnumDeserializer;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = JSONEnumDeserializer.class)
public enum TipoPessoa {
	
	FISICA("Física"),
	JURIDICA("Jurídica");
	
	private TipoPessoa(String descricao) {
		this.descricao = descricao;		
	}

	private final String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	@JsonProperty("value")
	public String getValue() {
		return name();
	}
}

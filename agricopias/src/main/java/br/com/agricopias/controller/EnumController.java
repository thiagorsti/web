package br.com.agricopias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.enums.TipoEndereco;
import br.com.agricopias.enums.TipoPessoa;
import br.com.agricopias.enums.Unidade;

@Controller
@RequestMapping("/enums")
public class EnumController {
	
	@RequestMapping(value = "/unidade", method = RequestMethod.GET)
	public @ResponseBody Unidade[] findAllUnidades() {
		return Unidade.values();
	}
	
	@RequestMapping(value = "tipoPessoa", method = RequestMethod.GET)
	public @ResponseBody TipoPessoa[] findAllTiposPessoa() {
		return TipoPessoa.values();
	}
	
	@RequestMapping(value = "tipoEndereco", method = RequestMethod.GET)
	public @ResponseBody TipoEndereco[] findAllTiposEndereco() {
		return TipoEndereco.values();
	}
}

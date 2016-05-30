package br.com.agricopias.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.TipoServico;

@Controller
@RequestMapping("/servico/tipos")
public class TipoServicoController {	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<TipoServico> findAll() {
		List<TipoServico> result = new ArrayList<>();
		result.add(new TipoServico(1L, "Tipo de Serviço 1"));
		result.add(new TipoServico(2L, "Tipo de Serviço 2"));
		result.add(new TipoServico(3L, "Tipo de Serviço 3"));
		result.add(new TipoServico(4L, "Tipo de Serviço 4"));
		result.add(new TipoServico(5L, "Tipo de Serviço 5"));
		result.add(new TipoServico(6L, "Tipo de Serviço 6"));
		return result;
	}
}

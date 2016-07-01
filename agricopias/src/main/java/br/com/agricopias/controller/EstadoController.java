package br.com.agricopias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.Estado;
import br.com.agricopias.service.EstadoService;

@Controller
@RequestMapping("/estados")
public class EstadoController {

	@Autowired	
	private EstadoService estadoService;	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Estado> findAll() {
		return estadoService.findAll();
	}
}

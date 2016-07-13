package br.com.agricopias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.Estado;
import br.com.agricopias.enums.repository.EstadoRepository;

@Controller
@RequestMapping("/estados")
public class EstadoController {

	@Autowired(required = false)	
	private EstadoRepository estadoRepository;	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Iterable<Estado> findAll() {
		return estadoRepository.findAllByOrderBySigla();		
	}
}

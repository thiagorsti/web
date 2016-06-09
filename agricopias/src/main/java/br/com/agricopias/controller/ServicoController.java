package br.com.agricopias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.Servico;
import br.com.agricopias.service.ServicoService;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Servico> findAll() {
		return servicoService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Servico findById(@PathVariable Long id) {
		return servicoService.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long id) {
		servicoService.delete(id);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Servico update(@PathVariable Long id, @RequestBody Servico servico) {
		return servicoService.update(id, servico);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Servico add(@RequestBody Servico servico) {
		return servicoService.add(servico);
	}
}

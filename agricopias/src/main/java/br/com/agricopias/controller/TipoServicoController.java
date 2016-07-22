package br.com.agricopias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.TipoServico;
import br.com.agricopias.repository.TipoServicoRepository;

@Controller
@RequestMapping("/servico/tipos")
public class TipoServicoController {	
	
	@Autowired
	private TipoServicoRepository tipoServicoRepository;	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Iterable<TipoServico> findAll() {
		return tipoServicoRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody TipoServico findById(@PathVariable Long id) {
		return tipoServicoRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long id) {
		tipoServicoRepository.deleteById(id);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody TipoServico update(@PathVariable Long id, @RequestBody TipoServico tipoServico) {
		return tipoServicoRepository.save(tipoServico);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody TipoServico add(@RequestBody TipoServico tipoServico) {
		return tipoServicoRepository.save(tipoServico);
	}
}

package br.com.agricopias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.Pessoa;
import br.com.agricopias.service.PessoaService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired	
	private PessoaService pessoaService;	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Pessoa> findAll() {
		return pessoaService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Pessoa findById(@PathVariable Long id) {
		return pessoaService.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long id) {
		pessoaService.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return pessoaService.update(id, pessoa);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Pessoa add(@RequestBody Pessoa pessoa) {
		return pessoaService.add(pessoa);
	}
}

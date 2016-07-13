package br.com.agricopias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.Pessoa;
import br.com.agricopias.enums.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired	
	private ClienteRepository clienteRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Iterable<Pessoa> findAll() {
		return clienteRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Pessoa findById(@PathVariable Long id) {
		return clienteRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return clienteRepository.save(pessoa);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Pessoa add(@RequestBody Pessoa pessoa) {
		return clienteRepository.save(pessoa);
	}
}

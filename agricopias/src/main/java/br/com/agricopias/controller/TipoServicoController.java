package br.com.agricopias.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.TipoServico;

@Controller
@RequestMapping("/servico/tipos")
public class TipoServicoController {	
	
	private static final List<TipoServico> tiposServico = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		tiposServico.add(new TipoServico(1L, "Tipo de Serviço 1"));
		tiposServico.add(new TipoServico(2L, "Tipo de Serviço 2"));
		tiposServico.add(new TipoServico(3L, "Tipo de Serviço 3"));
		tiposServico.add(new TipoServico(4L, "Tipo de Serviço 4"));
		tiposServico.add(new TipoServico(5L, "Tipo de Serviço 5"));
		tiposServico.add(new TipoServico(6L, "Tipo de Serviço 6"));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<TipoServico> findAll() {
		return tiposServico;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody TipoServico findById(@PathVariable Long id) {
		List<TipoServico> result = tiposServico.stream()
			.filter(ts -> ts.getId().equals(id))
			.limit(1)
			.collect(Collectors.toList());
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Long id) {
		TipoServico tipoServico = findById(id);
		tiposServico.remove(tipoServico);		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody TipoServico update(@PathVariable Long id, @RequestBody TipoServico tipoServico) {
		TipoServico old = findById(id);
		if (old == null) {
			return null;
		}
		Collections.replaceAll(tiposServico, old, tipoServico);
		return tipoServico;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody TipoServico add(@RequestBody TipoServico tipoServico) {
		Long id = tiposServico.stream().mapToLong(ts -> ts.getId()).max().orElseGet(() -> 0L) + 1;
		tipoServico.setId(id);
		tiposServico.add(tipoServico);
		return tipoServico;
	}
}

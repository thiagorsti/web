package br.com.agricopias.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agricopias.entity.Servico;

@Service
public class ServicoService {

private static final List<Servico> servicos = new ArrayList<>();
	
	@Autowired
	private TipoServicoService tipoServicoService;

	@PostConstruct
	public void init() {
		servicos.add(new Servico(1L, "Serviço 1", tipoServicoService.findById(1L), false));
		servicos.add(new Servico(2L, "Serviço 2", tipoServicoService.findById(2L), true));
	}	
	
	public List<Servico> findAll() {
		return servicos;
	}	
	
	public Servico findById(Long id) {
		List<Servico> result = servicos.stream()
			.filter(s -> s.getId().equals(id))
			.limit(1)
			.collect(Collectors.toList());
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public void delete(Long id) {
		Servico servico = findById(id);
		servicos.remove(servico);		
	}
	
	public Servico update(Long id, Servico servico) {
		Servico old = findById(id);
		if (old == null) {
			return null;
		}
		Collections.replaceAll(servicos, old, servico);
		return servico;
	}
	
	public Servico add(Servico servico) {
		Long id = servicos.stream().mapToLong(s -> s.getId()).max().orElseGet(() -> 0L) + 1;
		servico.setId(id);
		servicos.add(servico);
		return servico;
	}
}

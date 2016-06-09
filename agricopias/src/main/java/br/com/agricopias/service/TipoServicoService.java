package br.com.agricopias.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.com.agricopias.entity.TipoServico;

@Service
public class TipoServicoService {

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
	
	public List<TipoServico> findAll() {
		return tiposServico;
	}	
	
	public TipoServico findById(Long id) {
		List<TipoServico> result = tiposServico.stream()
			.filter(ts -> ts.getId().equals(id))
			.limit(1)
			.collect(Collectors.toList());
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public void delete(Long id) {
		TipoServico tipoServico = findById(id);
		tiposServico.remove(tipoServico);		
	}
	
	public TipoServico update(Long id, TipoServico tipoServico) {
		TipoServico old = findById(id);
		if (old == null) {
			return null;
		}
		Collections.replaceAll(tiposServico, old, tipoServico);
		return tipoServico;
	}
	
	public TipoServico add(TipoServico tipoServico) {
		Long id = tiposServico.stream().mapToLong(ts -> ts.getId()).max().orElseGet(() -> 0L) + 1;
		tipoServico.setId(id);
		tiposServico.add(tipoServico);
		return tipoServico;
	}
}

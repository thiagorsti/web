package br.com.agricopias.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agricopias.entity.Estado;

@Service
public class EstadoService {

	@Autowired
	private CidadeService cidadeService;
	
	private static final List<Estado> estados = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		estados.add(new Estado(1L, "Goiás", "GO"));
		estados.add(new Estado(2L, "São Paulo", "SP"));
//		if (estados.get(0).getCidades().isEmpty()) {
//			estados.get(0).getCidades().add(cidadeService.findById(1L));
//			estados.get(0).getCidades().add(cidadeService.findById(2L));
//		}
//		if (estados.get(1).getCidades().isEmpty()) {
//			estados.get(1).getCidades().add(cidadeService.findById(3L));
//			estados.get(1).getCidades().add(cidadeService.findById(4L));
//		}
	}
	
	public List<Estado> findAll() {
		return estados;
	}	
	
	public Estado findById(Long id) {
		List<Estado> result = estados.stream()
			.filter(e -> e.getId().equals(id))
			.limit(1)
			.collect(Collectors.toList());
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public void delete(Long id) {
		Estado estado = findById(id);
		estados.remove(estado);		
	}
	
	public Estado update(Long id, Estado estado) {
		Estado old = findById(id);
		if (old == null) {
			return null;
		}
		Collections.replaceAll(estados, old, estado);
		return estado;
	}
	
	public Estado add(Estado estado) {
		Long id = estados.stream().mapToLong(e -> e.getId()).max().orElseGet(() -> 0L) + 1;
		estado.setId(id);
		estados.add(estado);
		return estado;
	}
}

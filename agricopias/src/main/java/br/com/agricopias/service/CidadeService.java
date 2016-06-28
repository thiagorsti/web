package br.com.agricopias.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agricopias.entity.Cidade;
import br.com.agricopias.entity.Estado;

@Service
public class CidadeService {

	@Autowired
	private EstadoService estadoService;
	
	private static final List<Cidade> cidades = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Estado go = estadoService.findById(1L);
		Estado sp = estadoService.findById(2L);
		cidades.add(new Cidade(1L, "Goiânia", 1, go));
		cidades.add(new Cidade(2L, "Aparecida", 2, go));
		cidades.add(new Cidade(3L, "São Paulo", 3, sp));
		cidades.add(new Cidade(4L, "Campinas", 4, sp));
		if (go.getCidades().isEmpty()) {
			go.getCidades().add(cidades.get(0));
			go.getCidades().add(cidades.get(1));
		}
		if (sp.getCidades().isEmpty()) {
			sp.getCidades().add(cidades.get(2));
			sp.getCidades().add(cidades.get(3));
		}
	}	
	
	public List<Cidade> findAll() {
		return cidades;
	}	
	
	public Cidade findById(Long id) {
		List<Cidade> result = cidades.stream()
			.filter(c -> c.getId().equals(id))
			.limit(1)
			.collect(Collectors.toList());
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public void delete(Long id) {
		Cidade cidade = findById(id);
		cidades.remove(cidade);		
	}
	
	public Cidade update(Long id, Cidade cidade) {
		Cidade old = findById(id);
		if (old == null) {
			return null;
		}
		Collections.replaceAll(cidades, old, cidade);
		return cidade;
	}
	
	public Cidade add(Cidade cidade) {
		Long id = cidades.stream().mapToLong(c -> c.getId()).max().orElseGet(() -> 0L) + 1;
		cidade.setId(id);
		cidades.add(cidade);
		return cidade;
	}
}

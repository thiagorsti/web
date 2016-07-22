package br.com.agricopias.repository;

import org.springframework.data.repository.Repository;

import br.com.agricopias.entity.Cidade;

@org.springframework.stereotype.Repository
public interface CidadeRepository extends Repository<Cidade, Long> {

	Iterable<Cidade> findByEstado_IdAndNomeContainingOrderByNome(Long estadoId, String nome);
	
	Iterable<Cidade> findByEstado_IdOrderByNome(Long estadoId);
	
	Cidade findOne(Long id);
}

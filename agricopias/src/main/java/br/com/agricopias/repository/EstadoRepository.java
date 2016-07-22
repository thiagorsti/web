package br.com.agricopias.repository;

import org.springframework.data.repository.Repository;

import br.com.agricopias.entity.Estado;

@org.springframework.stereotype.Repository
public interface EstadoRepository extends Repository<Estado, Long> {

	Iterable<Estado> findAllByOrderBySigla();
	
	Estado findOne(Long id);
}

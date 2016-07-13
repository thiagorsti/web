package br.com.agricopias.enums.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.agricopias.entity.Pessoa;

public interface ClienteRepository extends PagingAndSortingRepository<Pessoa, Long> {
	
	@Modifying
	@Transactional
	@Query("update Pessoa p set p.hidden = true where id = ?1")
	public void deleteById(Long id);
}

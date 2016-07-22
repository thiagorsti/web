package br.com.agricopias.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.agricopias.entity.Servico;

@Repository
public interface ServicoRepository extends CrudRepository<Servico, Long> {
	
	@Modifying
	@Transactional
	@Query("update Servico s set s.hidden = true where id = ?1")
	public void deleteById(Long id);	
}

package br.com.agricopias.repository;

import br.com.agricopias.entity.TipoServico;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicoRepository extends CrudRepository<TipoServico, Long> {

	@Modifying
	@Transactional
	@Query("update TipoServico ts set ts.hidden = true where id = ?1")
	public void deleteById(Long id);
}

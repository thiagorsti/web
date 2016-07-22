package br.com.agricopias.repository.support;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.agricopias.entity.Pessoa;
import br.com.agricopias.entity.Pessoa_;

public class ClienteSpecs {

	public static Specification<Pessoa> hasCpfCnpj(String cpfCnpj) {
		return new Specification<Pessoa>() {
			@Override
			public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery<?> query, CriteriaBuilder cb) {				
				return cb.or(cb.equal(root.get(Pessoa_.cpf), cpfCnpj), cb.equal(root.get(Pessoa_.cnpj), cpfCnpj));
			}			
		};
	}
	
	public static Specification<Pessoa> containsNome(String nome) {
		return new Specification<Pessoa>() {
			@Override
			public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery<?> query, CriteriaBuilder cb) {				
				return cb.like(cb.lower(root.get(Pessoa_.nome)), "%"+nome.toLowerCase()+"%");
			}
		};
	}
	
	public static Specification<Pessoa> containsEmail(String email) {
		return new Specification<Pessoa>() {			
			@Override
			public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				Join<Pessoa, String> emailJoin = root.join(Pessoa_.emails);
				return cb.like(cb.lower(emailJoin), "%"+email.toLowerCase()+"%");
			}
		};
	}
	
	public static Specification<Pessoa> containsTelefone(String telefone) {
		return new Specification<Pessoa>() {
			@Override
			public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.distinct(true);
				Join<Pessoa, String> foneJoin = root.join(Pessoa_.telefones);
				return cb.like(foneJoin, "%"+telefone+"%");
			}
		};
	}
}

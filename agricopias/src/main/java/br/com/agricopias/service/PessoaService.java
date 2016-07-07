package br.com.agricopias.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agricopias.entity.Endereco;
import br.com.agricopias.entity.Pessoa;
import br.com.agricopias.enums.TipoEndereco;
import br.com.agricopias.enums.TipoPessoa;

@Service
public class PessoaService {

	@Autowired
	private CidadeService cidadeService;
	
	private static final List<Pessoa> pessoas = new ArrayList<>();
	
	@PostConstruct
	public void init() {		
		Endereco endereco = new Endereco();
		endereco.setBairro("Jd Maria Inez");
		endereco.setCep("74914465");
		endereco.setCidade(cidadeService.findById(1L));
		endereco.setComplemento("Apto 108, Bloco 2");
		endereco.setLogradouro("Rua Princesa Isabel");
		endereco.setTipo(TipoEndereco.COMERCIAL);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(endereco);
		pessoas.add(new Pessoa(1L, "Thiago", TipoPessoa.FISICA, "00368634167", "4130660", null, null, Arrays.asList(new String[]{"thiago@email1.com", "thiago@email2.com.br"}), enderecos));
		pessoas.add(new Pessoa(2L, "Moema", TipoPessoa.FISICA, "85787324480", "112233", null, null, Arrays.asList(new String[]{"moema@email1.com", "moema@email2.com.br"})));
		pessoas.add(new Pessoa(3L, "Empresa cliente", TipoPessoa.JURIDICA, null, null, "53757856000172", "6546546544", Arrays.asList(new String[]{"empresa@email1.com", "empresa@email2.com.br"})));
	}
	
	public List<Pessoa> findAll() {
		return pessoas;
	}	
	
	public Pessoa findById(Long id) {
		List<Pessoa> result = pessoas.stream()
			.filter(s -> s.getId().equals(id))
			.limit(1)
			.collect(Collectors.toList());
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	public void delete(Long id) {
		Pessoa pessoa = findById(id);
		pessoas.remove(pessoa);		
	}
	
	public Pessoa update(Long id, Pessoa pessoa) {
		Pessoa old = findById(id);
		if (old == null) {
			return null;
		}
		Collections.replaceAll(pessoas, old, pessoa);
		return pessoa;
	}
	
	public Pessoa add(Pessoa pessoa) {
		Long id = pessoas.stream().mapToLong(s -> s.getId()).max().orElseGet(() -> 0L) + 1;
		pessoa.setId(id);
		pessoas.add(pessoa);
		return pessoa;
	}
}

package br.com.agricopias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agricopias.entity.Cidade;
import br.com.agricopias.repository.CidadeRepository;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@RequestMapping(method = RequestMethod.GET, params = {"ufId", "nome"})
	public @ResponseBody Iterable<Cidade> findByNome(
			@RequestParam(value = "ufId", required = true) Long ufId, 
			@RequestParam(value = "nome", required = true) String nome) {
		return cidadeRepository.findByEstado_IdAndNomeContainingOrderByNome(ufId, nome);
	}
}

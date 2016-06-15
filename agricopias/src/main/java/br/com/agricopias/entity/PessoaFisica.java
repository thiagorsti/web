package br.com.agricopias.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import br.com.agricopias.util.Mascara;

public class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rg;

	@CPF
	private String cpf;

	public void setCpf(String cpf) {
		if (cpf != null)
			cpf = cpf.replaceAll("\\D", "");
		this.cpf = cpf;
	}

	public String getCpf() {
		if (cpf != null) {
			return cpf.replaceAll("\\D", "");
		}
		return null;
	}

	public void setRg(String rg) {
		if (rg != null) {
			if (rg.replaceAll("0", "").equals("")) {
				this.rg = null;
			}
		}
		this.rg = rg;
	}

	public String getRg() {
		return rg;
	}

	@Override
	public String getNumCadPessoaComMascara() {
		return Mascara.insereMascaraCpf(getCpf());
	}

}

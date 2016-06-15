package br.com.agricopias.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.agricopias.util.Mascara;

public class PessoaJuridica extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String ie;

	@CNPJ
	private String cnpj;

	public String getCnpj() {
		if (this.cnpj != null) {
			return cnpj.replaceAll("\\D", "");
		}
		return null;
	}

	public void setCnpj(String cnpj) {
		if (cnpj != null)
			cnpj = cnpj.replaceAll("\\D", "");
		this.cnpj = cnpj;
	}

	public void setIe(String ie) {
		if (ie != null) {
			if (ie.replaceAll("0", "").equals("")) {
				this.ie = null;
			}
		}
		this.ie = ie;
	}

	public String getIe() {
		return ie;
	}

	@Override
	public String getNumCadPessoaComMascara() {
		return Mascara.insereMascaraCnpj(getCnpj());
	}
}

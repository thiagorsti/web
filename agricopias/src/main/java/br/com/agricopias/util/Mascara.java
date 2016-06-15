package br.com.agricopias.util;

public class Mascara {
	
	public static String insereMascaraCpf(String cpf) {
		if (cpf == null)
			return null;
		if (cpf.length() == 11)
			return cpf.replaceAll("^(\\d{3})(\\d{3})(\\d{3})(\\d{2})$", "$1.$2.$3-$4");
		return null;
	}

	public static String insereMascaraCnpj(String cnpj) {
		if (cnpj == null)
			return null;
		if (cnpj.length() == 14)
			return cnpj.replaceAll("^(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})$", "$1.$2.$3/$4-$5");
		return null;
	}

	public static String insereMascaraFone(String fone) {
		if (fone == null)
			return null;
		if (fone.length() == 10)
			return fone.replaceAll("^(\\d{2})(\\d{4})(\\d{4})$", "($1) $2-$3");
		return null;
	}

	public static String insereMascaraCep(String cep) {
		if (cep == null)
			return null;
		if (cep.length() == 8)
			return cep.replaceAll("^(\\d{2})(\\d{3})(\\d{3})$", "$1.$2-$3");
		return null;
	}
}

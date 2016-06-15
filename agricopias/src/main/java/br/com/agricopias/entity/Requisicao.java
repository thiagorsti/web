package br.com.agricopias.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Requisicao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String numero;

	private Pessoa cliente;
	
	private String solicitante;
	
	private Usuario usuario;
	
	private Date data;
	
	private List<ItemRequisicao> itensRequisicao = new ArrayList<>();
	
	private String nomeObra;

	private BigDecimal desconto;
	
	private Boolean paga = Boolean.FALSE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNomeObra() {
		return nomeObra;
	}

	public void setNomeObra(String nomeObra) {
		this.nomeObra = nomeObra;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getNomeClienteOuSolicitante() {
		if (this.cliente != null)
			if (this.cliente.getId() != null)
				return this.cliente.getNome();
		if (this.solicitante != null)
			return this.solicitante;
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ItemRequisicao> getItensRequisicao() {
		return itensRequisicao;
	}

	public void setItemRequisicao(List<ItemRequisicao> itensRequisicao) {
		this.itensRequisicao = itensRequisicao;
	}

	public BigDecimal getDesconto() {
		return this.desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		BigDecimal valorItens = getValorItens();
		if (desconto > valorItens)
			desconto = valorItens;
		this.desconto = desconto;
	}

	public BigDecimal getPercentualDesconto() {
		BigDecimal perc = getDesconto() / getValorItens() * 100;
		return perc.isNaN() ? 0f : perc;
	}

	public void setPercentualDesconto(Float percentualDesconto) {
		if (percentualDesconto > 100)
			percentualDesconto = 100F;
		desconto = new BigDecimal(getValorItens() * percentualDesconto / 100).setScale(2, BigDecimal.ROUND_HALF_UP)
				.floatValue();
	}

	public Boolean getPaga() {
		return paga;
	}

	public void setPaga(Boolean paga) {
		this.paga = paga;
	}

	public BigDecimal getValorItens() {
		BigDecimal valorTotalItens = new BigDecimal(0);
		for (ItemRequisicao itemRequisicao : getItensRequisicao()) {
			valorTotalItens += itemRequisicao.getValorItem();
		}
		return valorTotalItens;
	}

	public BigDecimal getTotalDescontoItens() {
		BigDecimal descontoTotalItens = new BigDecimal(0);
		for (ItemRequisicao itemRequisicao : getItensRequisicao()) {
			descontoTotalItens += itemRequisicao.getDesconto() * itemRequisicao.getQuantidade();
		}
		return descontoTotalItens;
	}

	public BigDecimal getValorTotalItens() {
		return getValorItens() - getTotalDescontoItens();
	}

	public BigDecimal getDescontoTotal() {
		return getTotalDescontoItens() + getDesconto();
	}

	public Float getValorTotal() {
		return getValorTotalItens() - getDesconto();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Requisicao other = (Requisicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

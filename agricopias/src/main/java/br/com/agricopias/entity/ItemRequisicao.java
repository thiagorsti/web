package br.com.agricopias.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.agricopias.enums.Unidade;

public class ItemRequisicao implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer quantidade = new Integer(1);

	private Servico servico;

	private BigDecimal dimensao;

	private AreaChapada areaChapada = new AreaChapada();

	private BigDecimal desconto = new BigDecimal(0);

	private BigDecimal valorServico;
	
	private BigDecimal valorAreaChapadaServico;

	public ItemRequisicao() {
	}

	public ItemRequisicao(Servico servico) {
		setServico(servico);
	}

	public ItemRequisicao(Servico servico, Float dimensao) {
		setServico(servico);
		setDimensao(dimensao);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		if (quantidade < 1)
			quantidade = 1;
		this.quantidade = quantidade;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
		if (this.servico != null) {
			if (this.servico.getUnidade() != null) {
				if (this.servico.getUnidade().equals(Unidade.UNITARIO))
					setDimensao(0);
				else if (getDimensao() == null || getDimensao() == 0)
					setDimensao(1);
			}
		}
	}

	public BigDecimal getDimensao() {
		return dimensao;
	}

	public void setDimensao(BigDecimal dimensao) {
		this.dimensao = dimensao;
	}

	public AreaChapada getAreaChapada() {
		return areaChapada;
	}

	public void setAreaChapada(AreaChapada areaChapada) {
		this.areaChapada = areaChapada;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	public BigDecimal getValorAreaChapadaServico() {
		if (valorAreaChapadaServico == null)
			setValorAreaChapadaServico(getServico().getValorAreaChapada());
		return valorAreaChapadaServico;
	}

	public void setValorAreaChapadaServico(BigDecimal valorAreaChapadaServico) {
		this.valorAreaChapadaServico = valorAreaChapadaServico;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) throws Exception {
		if (this.getValorServico() < desconto)
			desconto = this.getValorServico();
		this.desconto = desconto;
	}

	public final BigDecimal getValorServico() {
		if (valorServico == null)
			setValorServico(getServico().getValor());
		return valorServico;
	}

	public BigDecimal getValorTotalAreaChapada() {
		return getAreaChapada().getArea() * getAreaChapada().getPorcentagem() / 100 * getValorAreaChapadaServico();
	}

	public BigDecimal getValorTotalServico() {
		if (getServico().getUnidade().equals(Unidade.UNITARIO))
			return getValorServico() + getValorTotalAreaChapada();
		return getValorServico() * getDimensao() + getValorTotalAreaChapada();
	}

	public BigDecimal getValorItem() {
		return getValorTotalServico() * getQuantidade();
	}

	public BigDecimal getValorTotal() {
		return (getValorTotalServico() - getDesconto()) * getQuantidade();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaChapada == null) ? 0 : areaChapada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
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
		ItemRequisicao other = (ItemRequisicao) obj;
		if (areaChapada == null) {
			if (other.areaChapada != null)
				return false;
		} else if (!areaChapada.equals(other.areaChapada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}
}

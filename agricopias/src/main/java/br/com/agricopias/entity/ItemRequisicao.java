package br.com.agricopias.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.agricopias.enums.Unidade;

@Entity
public class ItemRequisicao implements Serializable {

	private static final long serialVersionUID = -5745397868761804311L;

	@Id
	@SequenceGenerator(name = "item_requisicao_gen", sequenceName = "item_requisicao_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_requisicao_gen")
	private Long id;	

	@Column(nullable = false)
	private Integer quantidade = Integer.valueOf(1);

	@ManyToOne
	@JoinColumn(nullable = false)
	private Servico servico;

	@Column(scale = 5, precision = 2)
	private BigDecimal dimensao;

	@Embedded
	private AreaChapada areaChapada = new AreaChapada();

	@Column(scale = 5, precision = 2, nullable = false)
	private BigDecimal desconto = BigDecimal.ZERO;

	@Column(scale = 5, precision = 2, nullable = false)
	private BigDecimal valorServico;
	
	@Column(name = "valor_area_chap_serv", scale = 5, precision = 2)
	private BigDecimal valorAreaChapadaServico;

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
		if (this.servico != null && Unidade.UNITARIO.equals(this.servico.getUnidade())) {			
			setDimensao(BigDecimal.ZERO);
		}
		else if (getDimensao() == null || getDimensao().doubleValue() == 0) {
			setDimensao(BigDecimal.ONE);		
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
		if (this.getValorServico().doubleValue() < desconto.doubleValue())
			desconto = this.getValorServico();
		this.desconto = desconto;
	}

	public final BigDecimal getValorServico() {
		if (valorServico == null)
			setValorServico(getServico().getValor());
		return valorServico;
	}

	public BigDecimal getValorTotalAreaChapada() {
		return areaChapada.getArea().multiply(areaChapada.getPercentual().divide(BigDecimal.valueOf(100)).multiply(getValorAreaChapadaServico()));
	}

	public BigDecimal getValorTotalServico() {
		if (getServico().getUnidade().equals(Unidade.UNITARIO))
			return getValorServico().add(getValorTotalAreaChapada());
		return getValorServico().multiply(getDimensao()).add(getValorTotalAreaChapada());
	}

	public BigDecimal getValorItem() {
		return getValorTotalServico().multiply(BigDecimal.valueOf(quantidade));
	}

	public BigDecimal getValorTotal() {
		return getValorTotalServico().subtract(getDesconto().multiply(BigDecimal.valueOf(quantidade)));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaChapada == null) ? 0 : areaChapada.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
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
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}
}

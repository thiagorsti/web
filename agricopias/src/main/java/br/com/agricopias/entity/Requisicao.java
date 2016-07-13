package br.com.agricopias.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Requisicao implements Serializable {

	private static final long serialVersionUID = 8940735692923055896L;

	@Id
	@SequenceGenerator(name = "requisicao_gen", sequenceName = "requisicao_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requisicao_gen")
	private Long id;

	@Column(length = 20, nullable = false)
	private String numero;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa cliente;
	
	@Column(length = 60)
	private String solicitante;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;
	
	@OneToMany(cascade = CascadeType.ALL)	
	private List<ItemRequisicao> itensRequisicao = new ArrayList<>();
	
	@Column(length = 100)
	private String nomeObra;

	@Column(scale = 5, precision = 2, nullable = false)
	private BigDecimal desconto = BigDecimal.ZERO;
	
	@Column(nullable = false)
	private Boolean paga;
	
	@Column(nullable = false)
	private Boolean hidden = Boolean.FALSE;

	public List<ItemRequisicao> getItensRequisicao() {
		return itensRequisicao;
	}

	public void setItensRequisicao(List<ItemRequisicao> itensRequisicao) {
		this.itensRequisicao = itensRequisicao;
	}

	public BigDecimal getDesconto() {
		return this.desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		BigDecimal valorItens = getValorItens();
		if (desconto != null && desconto.doubleValue() > valorItens.doubleValue())
			desconto = valorItens;
		this.desconto = desconto;
	}

	public BigDecimal getPercentualDesconto() {
		try {
			BigDecimal perc = getDesconto().divide(getValorItens()).multiply(BigDecimal.valueOf(100));
			return perc;
		}
		catch(ArithmeticException ae) {
			return BigDecimal.ZERO;
		}		
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		if (percentualDesconto != null && percentualDesconto.doubleValue() > 100)
			percentualDesconto = BigDecimal.valueOf(100);
		desconto = getValorItens().multiply(percentualDesconto).divide(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getValorItens() {
		BigDecimal valorTotalItens = BigDecimal.ZERO;
		for (ItemRequisicao itemRequisicao : getItensRequisicao()) {
			valorTotalItens = valorTotalItens.add(itemRequisicao.getValorItem());
		}
		return valorTotalItens;
	}

	public BigDecimal getTotalDescontoItens() {
		BigDecimal descontoTotalItens = BigDecimal.ZERO;
		for (ItemRequisicao itemRequisicao : getItensRequisicao()) {
			descontoTotalItens = descontoTotalItens.add(itemRequisicao.getDesconto().multiply(BigDecimal.valueOf(itemRequisicao.getQuantidade())));
		}
		return descontoTotalItens;
	}

	public BigDecimal getValorTotalItens() {
		return getValorItens().subtract(getTotalDescontoItens());
	}

	public BigDecimal getDescontoTotal() {
		return getTotalDescontoItens().add(getDesconto());
	}

	public BigDecimal getValorTotal() {
		return getValorTotalItens().subtract(getDesconto());
	}

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNomeObra() {
		return nomeObra;
	}

	public void setNomeObra(String nomeObra) {
		this.nomeObra = nomeObra;
	}

	public Boolean getPaga() {
		return paga;
	}

	public void setPaga(Boolean paga) {
		this.paga = paga;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
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

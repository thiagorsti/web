package br.com.agricopias.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AreaChapada implements Serializable {
	
	private static final long serialVersionUID = 8992102973240547098L;

	@Column(name = "area_chapada", scale = 5, precision = 2)
	private BigDecimal area = BigDecimal.ZERO;

	@Column(name = "perc_area_chapada", scale = 5, precision = 2)
	private BigDecimal percentual = BigDecimal.ZERO;

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		if (percentual != null && percentual.doubleValue() > 100)
			percentual = BigDecimal.valueOf(100);
		this.percentual = percentual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((percentual == null) ? 0 : percentual.hashCode());
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
		AreaChapada other = (AreaChapada) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (percentual == null) {
			if (other.percentual != null)
				return false;
		} else if (!percentual.equals(other.percentual))
			return false;
		return true;
	}
}

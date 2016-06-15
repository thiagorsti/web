//package br.com.agricopias.entity;
//
//import java.io.Serializable;
//
//public class AreaChapada implements Serializable {
//	
//	private static final long serialVersionUID = 1L;
//	
//	private Long id;
//
//	private Float area = new Float(0);
//
//	private Float porcentagem = new Float(0);
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Float getArea() {
//		return area;
//	}
//
//	public void setArea(Float area) {
//		this.area = area;
//	}
//
//	public Float getPorcentagem() {
//		return porcentagem;
//	}
//
//	public void setPorcentagem(Float porcentagem) {
//		if (porcentagem > 100)
//			porcentagem = 100f;
//		this.porcentagem = porcentagem;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((area == null) ? 0 : area.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((porcentagem == null) ? 0 : porcentagem.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		AreaChapada other = (AreaChapada) obj;
//		if (area == null) {
//			if (other.area != null)
//				return false;
//		} else if (!area.equals(other.area))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (porcentagem == null) {
//			if (other.porcentagem != null)
//				return false;
//		} else if (!porcentagem.equals(other.porcentagem))
//			return false;
//		return true;
//	}
//}

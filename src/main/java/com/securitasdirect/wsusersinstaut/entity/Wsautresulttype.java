package com.securitasdirect.wsusersinstaut.entity;

import com.securitasdirect.wsusersinstaut.entity.Wsautuserschglog;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "WSAUTRESULTTYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Wsautresulttype.findAll", query = "SELECT w FROM Wsautresulttype w"),
		@NamedQuery(name = "Wsautresulttype.findByIdResultType", query = "SELECT w FROM Wsautresulttype w WHERE w.idResultType = :idResultType"),
		@NamedQuery(name = "Wsautresulttype.findByDescResultType", query = "SELECT w FROM Wsautresulttype w WHERE w.descResultType = :descResultType") })
public class Wsautresulttype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "idResultType")
	private Integer idResultType;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "descResultType")
	private String descResultType;
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "idResultType")
	private Collection<Wsautuserschglog> wsautuserschglogCollection;

	public Wsautresulttype() {
	}

	public Wsautresulttype(Integer idResultType) {
		this.idResultType = idResultType;
	}

	public Wsautresulttype(Integer idResultType, String descResultType) {
		this.idResultType = idResultType;
		this.descResultType = descResultType;
	}

	public Integer getIdResultType() {
		return this.idResultType;
	}

	public void setIdResultType(Integer idResultType) {
		this.idResultType = idResultType;
	}

	public String getDescResultType() {
		return this.descResultType;
	}

	public void setDescResultType(String descResultType) {
		this.descResultType = descResultType;
	}

	@XmlTransient
	public Collection<Wsautuserschglog> getWsautuserschglogCollection() {
		return this.wsautuserschglogCollection;
	}

	public void setWsautuserschglogCollection(Collection<Wsautuserschglog> wsautuserschglogCollection) {
		this.wsautuserschglogCollection = wsautuserschglogCollection;
	}

	public int hashCode() {
		int hash = 0;
		hash += (this.idResultType != null) ? this.idResultType.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.wsusersinstaut.entity.Wsautresulttype)) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.Wsautresulttype other = (com.securitasdirect.wsusersinstaut.entity.Wsautresulttype) object;
		if ((this.idResultType == null && other.idResultType != null)
				|| (this.idResultType != null && !this.idResultType.equals(other.idResultType))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.Wsautresulttype[ idResultType=" + this.idResultType + " ]";
	}
}

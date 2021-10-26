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
@Table(name = "WSAUTACTIONTYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Wsautactiontype.findAll", query = "SELECT w FROM Wsautactiontype w"),
		@NamedQuery(name = "Wsautactiontype.findByIdActionType", query = "SELECT w FROM Wsautactiontype w WHERE w.idActionType = :idActionType"),
		@NamedQuery(name = "Wsautactiontype.findByDescActionType", query = "SELECT w FROM Wsautactiontype w WHERE w.descActionType = :descActionType") })
public class Wsautactiontype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "idActionType")
	private Integer idActionType;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "descActionType")
	private String descActionType;
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "idActionType")
	private Collection<Wsautuserschglog> wsautuserschglogCollection;

	public Wsautactiontype() {
	}

	public Wsautactiontype(Integer idActionType) {
		this.idActionType = idActionType;
	}

	public Wsautactiontype(Integer idActionType, String descActionType) {
		this.idActionType = idActionType;
		this.descActionType = descActionType;
	}

	public Integer getIdActionType() {
		return this.idActionType;
	}

	public void setIdActionType(Integer idActionType) {
		this.idActionType = idActionType;
	}

	public String getDescActionType() {
		return this.descActionType;
	}

	public void setDescActionType(String descActionType) {
		this.descActionType = descActionType;
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
		hash += (this.idActionType != null) ? this.idActionType.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.wsusersinstaut.entity.Wsautactiontype)) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.Wsautactiontype other = (com.securitasdirect.wsusersinstaut.entity.Wsautactiontype) object;
		if ((this.idActionType == null && other.idActionType != null)
				|| (this.idActionType != null && !this.idActionType.equals(other.idActionType))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.Wsautactiontype[ idActionType=" + this.idActionType + " ]";
	}
}

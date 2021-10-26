package com.securitasdirect.wsusersinstaut.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "autoincremental")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Autoincremental.findAllAutoincremental", query = "SELECT a FROM Autoincremental a WHERE 1=1") })
public class Autoincremental implements Serializable {
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "idInst")
	private int idInst;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idUser")
	private int idUser;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idCambio")
	private int idCambio;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idXmpp")
	@Id
	private int idXmpp;

	public int getIdInst() {
		return this.idInst;
	}

	public void setIdInst(int idInst) {
		this.idInst = idInst;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdCambio() {
		return this.idCambio;
	}

	public void setIdCambio(int idCambio) {
		this.idCambio = idCambio;
	}

	public int getIdXmpp() {
		return this.idXmpp;
	}

	public void setIdXmpp(int idXmpp) {
		this.idXmpp = idXmpp;
	}

	public int hashCode() {
		int hash = 5;
		hash = 59 * hash + this.idInst;
		hash = 59 * hash + this.idUser;
		hash = 59 * hash + this.idCambio;
		hash = 59 * hash + this.idXmpp;
		return hash;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.Autoincremental other = (com.securitasdirect.wsusersinstaut.entity.Autoincremental) obj;
		if (this.idInst != other.idInst) {
			return false;
		}
		if (this.idUser != other.idUser) {
			return false;
		}
		if (this.idCambio != other.idCambio) {
			return false;
		}
		if (this.idXmpp != other.idXmpp) {
			return false;
		}
		return true;
	}
}

package com.securitasdirect.wsusersinstaut.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class InstallationsUsersPK implements Serializable {
	@Basic(optional = false)
	@NotNull
	@Column(name = "idInst")
	private int idInst;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idUser")
	private int idUser;

	public InstallationsUsersPK() {
	}

	public InstallationsUsersPK(int idInst, int idUser) {
		this.idInst = idInst;
		this.idUser = idUser;
	}

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

	public int hashCode() {
		int hash = 3;
		hash = 73 * hash + this.idInst;
		hash = 73 * hash + this.idUser;
		return hash;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.InstallationsUsersPK other = (com.securitasdirect.wsusersinstaut.entity.InstallationsUsersPK) obj;
		if (this.idInst != other.idInst) {
			return false;
		}
		if (this.idUser != other.idUser) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "InstallationsUsersPK{idInst=" + this.idInst + ", idUser=" + this.idUser + '}';
	}
}

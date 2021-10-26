package com.securitasdirect.wsusersinstaut.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class InstallationsPK implements Serializable {
	@Basic(optional = false)
	@NotNull
	@Column(name = "idCountry")
	private int idCountry;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "numinst")
	private String numinst;

	public InstallationsPK() {
	}

	public InstallationsPK(int idCountry, String numinst) {
		this.idCountry = idCountry;
		this.numinst = numinst;
	}

	public int getIdCountry() {
		return this.idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getNuminst() {
		return this.numinst;
	}

	public void setNuminst(String numinst) {
		this.numinst = numinst;
	}

	public int hashCode() {
		int hash = 0;
		hash += this.idCountry;
		hash += (this.numinst != null) ? this.numinst.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.wsusersinstaut.entity.InstallationsPK)) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.InstallationsPK other = (com.securitasdirect.wsusersinstaut.entity.InstallationsPK) object;
		if (this.idCountry != other.idCountry) {
			return false;
		}
		if ((this.numinst == null && other.numinst != null)
				|| (this.numinst != null && !this.numinst.equals(other.numinst))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.InstallationsPK[ idCountry=" + this.idCountry + ", numinst="
				+ this.numinst + " ]";
	}
}

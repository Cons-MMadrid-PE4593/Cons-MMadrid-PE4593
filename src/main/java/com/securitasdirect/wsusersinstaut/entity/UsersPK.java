package com.securitasdirect.wsusersinstaut.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class UsersPK implements Serializable {
	@Basic(optional = false)
	@NotNull
	@Column(name = "idCountry")
	private int idCountry;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "login")
	private String login;

	public UsersPK() {
	}

	public UsersPK(int idCountry, String login) {
		this.idCountry = idCountry;
		this.login = login;
	}

	public int getIdCountry() {
		return this.idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int hashCode() {
		int hash = 0;
		hash += this.idCountry;
		hash += (this.login != null) ? this.login.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.wsusersinstaut.entity.UsersPK)) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.UsersPK other = (com.securitasdirect.wsusersinstaut.entity.UsersPK) object;
		if (this.idCountry != other.idCountry) {
			return false;
		}
		if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.UsersPK[ idCountry=" + this.idCountry + ", login=" + this.login
				+ " ]";
	}
}

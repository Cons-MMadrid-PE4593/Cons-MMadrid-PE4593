package com.securitasdirect.wsusersinstaut.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "installations")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Installations.findAll", query = "SELECT i FROM Installations i"),
		@NamedQuery(name = "Installations.findByIdCountry", query = "SELECT i FROM Installations i WHERE i.installationsPK.idCountry = :idCountry"),
		@NamedQuery(name = "Installations.findByNuminst", query = "SELECT i FROM Installations i WHERE i.installationsPK.numinst = :numinst and  i.installationsPK.idCountry = 2"),
		@NamedQuery(name = "Installations.findByNuminstMC", query = "SELECT i FROM Installations i WHERE i.installationsPK.numinst = :numinst and  i.installationsPK.idCountry = :idCountry"),
		@NamedQuery(name = "Installations.findByNuminstAndIdCountry", query = "SELECT i FROM Installations i WHERE i.installationsPK.numinst = :numinst and  i.installationsPK.idCountry = :idCountry"),
		@NamedQuery(name = "Installations.findByIdInstMC", query = "SELECT i FROM Installations i WHERE i.idInst = :idInst and  i.installationsPK.idCountry = :idCountry"),
		@NamedQuery(name = "Installations.findByAlias", query = "SELECT i FROM Installations i WHERE i.alias = :alias"),
		@NamedQuery(name = "Installations.findByNotificationsEmail", query = "SELECT i FROM Installations i WHERE i.notificationsEmail = :notificationsEmail"),
		@NamedQuery(name = "Installations.findByNotificationsPhone", query = "SELECT i FROM Installations i WHERE i.notificationsPhone = :notificationsPhone"),
		@NamedQuery(name = "Installations.findByNotificationsLanguage", query = "SELECT i FROM Installations i WHERE i.notificationsLanguage = :notificationsLanguage") })
public class Installations implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected InstallationsPK installationsPK;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idInst")
	private int idInst;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "alias")
	private String alias;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "notificationsEmail")
	private String notificationsEmail;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "notificationsPhone")
	private String notificationsPhone;
	@Basic(optional = false)
	@NotNull
	@Column(name = "notificationsLanguage")
	private int notificationsLanguage;

	public Installations() {
	}

	public Installations(InstallationsPK installationsPK) {
		this.installationsPK = installationsPK;
	}

	public Installations(InstallationsPK installationsPK, int idInst, String alias, String notificationsEmail,
			String notificationsPhone, int notificationsLanguage) {
		this.installationsPK = installationsPK;
		this.idInst = idInst;
		this.alias = alias;
		this.notificationsEmail = notificationsEmail;
		this.notificationsPhone = notificationsPhone;
		this.notificationsLanguage = notificationsLanguage;
	}

	public Installations(int idCountry, String numinst) {
		this.installationsPK = new InstallationsPK(idCountry, numinst);
	}

	public InstallationsPK getInstallationsPK() {
		return this.installationsPK;
	}

	public void setInstallationsPK(InstallationsPK installationsPK) {
		this.installationsPK = installationsPK;
	}

	public int getIdInst() {
		return this.idInst;
	}

	public void setIdInst(int idInst) {
		this.idInst = idInst;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNotificationsEmail() {
		return this.notificationsEmail;
	}

	public void setNotificationsEmail(String notificationsEmail) {
		this.notificationsEmail = notificationsEmail;
	}

	public String getNotificationsPhone() {
		return this.notificationsPhone;
	}

	public void setNotificationsPhone(String notificationsPhone) {
		this.notificationsPhone = notificationsPhone;
	}

	public int getNotificationsLanguage() {
		return this.notificationsLanguage;
	}

	public void setNotificationsLanguage(int notificationsLanguage) {
		this.notificationsLanguage = notificationsLanguage;
	}

	public int hashCode() {
		int hash = 0;
		hash += (this.installationsPK != null) ? this.installationsPK.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.wsusersinstaut.entity.Installations)) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.Installations other = (com.securitasdirect.wsusersinstaut.entity.Installations) object;
		if ((this.installationsPK == null && other.installationsPK != null)
				|| (this.installationsPK != null && !this.installationsPK.equals(other.installationsPK))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.Installations[ installationsPK=" + this.installationsPK + " ]";
	}
}

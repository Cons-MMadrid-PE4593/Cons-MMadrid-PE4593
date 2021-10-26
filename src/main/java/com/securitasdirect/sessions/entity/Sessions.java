package com.securitasdirect.sessions.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Sessions")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Sessions.findAllSessions", query = "SELECT a FROM Sessions a WHERE 1=1"),
		@NamedQuery(name = "Sessions.findByHash", query = "SELECT a FROM Sessions a WHERE a.hash=:id_hash") })
public class Sessions implements Serializable {
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "numinst")
	private String numinst;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "identifier")
	private String identifier;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 5)
	@Column(name = "country")
	private String country;
	@Basic(optional = false)
	@NotNull
	@Column(name = "enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;
	@Basic(optional = false)
	@NotNull
	@Column(name = "startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	@Basic(optional = false)
	@NotNull
	@Column(name = "status")
	private int status;
	@Basic(optional = false)
	@NotNull
	@Column(name = "platform")
	private int platform;
	@Basic(optional = false)
	@NotNull
	@Column(name = "type")
	private int type;
	@Basic(optional = false)
	@NotNull
	@Column(name = "hash")
	@Id
	private int hash;

	public String getNuminst() {
		return this.numinst;
	}

	public void setNuminst(String numinst) {
		this.numinst = numinst;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPlatform() {
		return this.platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getHash() {
		return this.hash;
	}

	public void setIdXmpp(int hash) {
		this.hash = hash;
	}

	public int hashCode() {
		int hash = 5;

		hash = 59 * hash + this.hash;
		return hash;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		com.securitasdirect.sessions.entity.Sessions other = (com.securitasdirect.sessions.entity.Sessions) obj;
		if (!this.identifier.equals(other.identifier)) {
			return false;
		}
		if (!this.numinst.equals(other.numinst)) {
			return false;
		}

		if (this.hash != other.hash) {
			return false;
		}
		return true;
	}
}

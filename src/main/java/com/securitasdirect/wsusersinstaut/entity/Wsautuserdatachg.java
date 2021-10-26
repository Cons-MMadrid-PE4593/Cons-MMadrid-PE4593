package com.securitasdirect.wsusersinstaut.entity;

import com.securitasdirect.wsusersinstaut.entity.Wsautuserschglog;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "WSAUTUSERDATACHG")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Wsautuserdatachg.findAll", query = "SELECT w FROM Wsautuserdatachg w"),
		@NamedQuery(name = "Wsautuserdatachg.findByIdUserDataChg", query = "SELECT w FROM Wsautuserdatachg w WHERE w.idUserDataChg = :idUserDataChg"),
		@NamedQuery(name = "Wsautuserdatachg.findByOldUsPass", query = "SELECT w FROM Wsautuserdatachg w WHERE w.oldUsPass = :oldUsPass"),
		@NamedQuery(name = "Wsautuserdatachg.findByNewUsPass", query = "SELECT w FROM Wsautuserdatachg w WHERE w.newUsPass = :newUsPass"),
		@NamedQuery(name = "Wsautuserdatachg.findByGenUsPass", query = "SELECT w FROM Wsautuserdatachg w WHERE w.genUsPass = :genUsPass"),
		@NamedQuery(name = "Wsautuserdatachg.findByOldUsEmail", query = "SELECT w FROM Wsautuserdatachg w WHERE w.oldUsEmail = :oldUsEmail"),
		@NamedQuery(name = "Wsautuserdatachg.findByNewUsEmail", query = "SELECT w FROM Wsautuserdatachg w WHERE w.newUsEmail = :newUsEmail"),
		@NamedQuery(name = "Wsautuserdatachg.findByOldUsName", query = "SELECT w FROM Wsautuserdatachg w WHERE w.oldUsName = :oldUsName"),
		@NamedQuery(name = "Wsautuserdatachg.findByNewUsName", query = "SELECT w FROM Wsautuserdatachg w WHERE w.newUsName = :newUsName") })
public class Wsautuserdatachg implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "idUserDataChg")
	private Integer idUserDataChg;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 32)
	@Column(name = "old_us_pass")
	private String oldUsPass;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 32)
	@Column(name = "new_us_pass")
	private String newUsPass;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 32)
	@Column(name = "gen_us_pass")
	private String genUsPass;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "old_us_email")
	private String oldUsEmail;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "new_us_email")
	private String newUsEmail;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "old_us_name")
	private String oldUsName;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "new_us_name")
	private String newUsName;
	@JoinColumn(name = "idUserChgLog", referencedColumnName = "idUserChgLog")
	@ManyToOne(optional = false)
	private Wsautuserschglog idUserChgLog;

	public Wsautuserdatachg() {
	}

	public Wsautuserdatachg(Integer idUserDataChg) {
		this.idUserDataChg = idUserDataChg;
	}

	public Wsautuserdatachg(Integer idUserDataChg, String oldUsPass, String newUsPass, String genUsPass,
			String oldUsEmail, String newUsEmail, String oldUsName, String newUsName) {
		this.idUserDataChg = idUserDataChg;
		this.oldUsPass = oldUsPass;
		this.newUsPass = newUsPass;
		this.genUsPass = genUsPass;
		this.oldUsEmail = oldUsEmail;
		this.newUsEmail = newUsEmail;
		this.oldUsName = oldUsName;
		this.newUsName = newUsName;
	}

	public Integer getIdUserDataChg() {
		return this.idUserDataChg;
	}

	public void setIdUserDataChg(Integer idUserDataChg) {
		this.idUserDataChg = idUserDataChg;
	}

	public String getOldUsPass() {
		return this.oldUsPass;
	}

	public void setOldUsPass(String oldUsPass) {
		this.oldUsPass = oldUsPass;
	}

	public String getNewUsPass() {
		return this.newUsPass;
	}

	public void setNewUsPass(String newUsPass) {
		this.newUsPass = newUsPass;
	}

	public String getGenUsPass() {
		return this.genUsPass;
	}

	public void setGenUsPass(String genUsPass) {
		this.genUsPass = genUsPass;
	}

	public String getOldUsEmail() {
		return this.oldUsEmail;
	}

	public void setOldUsEmail(String oldUsEmail) {
		this.oldUsEmail = oldUsEmail;
	}

	public String getNewUsEmail() {
		return this.newUsEmail;
	}

	public void setNewUsEmail(String newUsEmail) {
		this.newUsEmail = newUsEmail;
	}

	public String getOldUsName() {
		return this.oldUsName;
	}

	public void setOldUsName(String oldUsName) {
		this.oldUsName = oldUsName;
	}

	public String getNewUsName() {
		return this.newUsName;
	}

	public void setNewUsName(String newUsName) {
		this.newUsName = newUsName;
	}

	public Wsautuserschglog getIdUserChgLog() {
		return this.idUserChgLog;
	}

	public void setIdUserChgLog(Wsautuserschglog idUserChgLog) {
		this.idUserChgLog = idUserChgLog;
	}

	public int hashCode() {
		int hash = 0;
		hash += (this.idUserDataChg != null) ? this.idUserDataChg.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.wsusersinstaut.entity.Wsautuserdatachg)) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.Wsautuserdatachg other = (com.securitasdirect.wsusersinstaut.entity.Wsautuserdatachg) object;
		if ((this.idUserDataChg == null && other.idUserDataChg != null)
				|| (this.idUserDataChg != null && !this.idUserDataChg.equals(other.idUserDataChg))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.Wsautuserdatachg[ idUserDataChg=" + this.idUserDataChg + " ]";
	}
}

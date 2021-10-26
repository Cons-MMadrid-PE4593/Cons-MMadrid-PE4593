package com.securitasdirect.wsusersinstaut.entity;

import com.securitasdirect.wsusersinstaut.entity.Installations;
import com.securitasdirect.wsusersinstaut.entity.Users;
import com.securitasdirect.wsusersinstaut.entity.Wsautactiontype;
import com.securitasdirect.wsusersinstaut.entity.Wsautresulttype;
import com.securitasdirect.wsusersinstaut.entity.Wsautuserdatachg;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "WSAUTUSERSCHGLOG")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Wsautuserschglog.findAll", query = "SELECT w FROM Wsautuserschglog w"),
		@NamedQuery(name = "Wsautuserschglog.findByIdUserChgLog", query = "SELECT w FROM Wsautuserschglog w WHERE w.idUserChgLog = :idUserChgLog"),
		@NamedQuery(name = "Wsautuserschglog.findByMatricula", query = "SELECT w FROM Wsautuserschglog w WHERE w.matricula = :matricula"),
		@NamedQuery(name = "Wsautuserschglog.findByDateUserChg", query = "SELECT w FROM Wsautuserschglog w WHERE w.dateUserChg = :dateUserChg"),
		@NamedQuery(name = "Wsautuserschglog.findByUsName", query = "SELECT w FROM Wsautuserschglog w WHERE w.usName = :usName"),
		@NamedQuery(name = "Wsautuserschglog.findByUsLastName", query = "SELECT w FROM Wsautuserschglog w WHERE w.usLastName = :usLastName"),
		@NamedQuery(name = "Wsautuserschglog.findByUsAddress", query = "SELECT w FROM Wsautuserschglog w WHERE w.usAddress = :usAddress"),
		@NamedQuery(name = "Wsautuserschglog.findByUsMail", query = "SELECT w FROM Wsautuserschglog w WHERE w.usMail = :usMail"),
		@NamedQuery(name = "Wsautuserschglog.findByUsPhone", query = "SELECT w FROM Wsautuserschglog w WHERE w.usPhone = :usPhone") })
public class Wsautuserschglog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "idUserChgLog")
	private Integer idUserChgLog;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "matricula")
	private String matricula;
	@Basic(optional = false)
	@NotNull
	@Column(name = "dateUserChg")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUserChg;
	@Size(max = 20)
	@Column(name = "usName")
	private String usName;
	@Size(max = 50)
	@Column(name = "usLastName")
	private String usLastName;
	@Size(max = 100)
	@Column(name = "usAddress")
	private String usAddress;
	@Size(max = 100)
	@Column(name = "usMail")
	private String usMail;
	@Size(max = 20)
	@Column(name = "usPhone")
	private String usPhone;
	@JoinColumn(name = "idUser", referencedColumnName = "idUser")
	@ManyToOne(optional = false)
	private Users idUser;
	@JoinColumn(name = "idInst", referencedColumnName = "idInst")
	@ManyToOne(optional = false)
	private Installations idInst;
	@JoinColumn(name = "idResultType", referencedColumnName = "idResultType")
	@ManyToOne(optional = false)
	private Wsautresulttype idResultType;
	@JoinColumn(name = "idActionType", referencedColumnName = "idActionType")
	@ManyToOne(optional = false)
	private Wsautactiontype idActionType;
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "idUserChgLog")
	private Collection<Wsautuserdatachg> wsautuserdatachgCollection;

	public Wsautuserschglog() {
	}

	public Wsautuserschglog(Integer idUserChgLog) {
		this.idUserChgLog = idUserChgLog;
	}

	public Wsautuserschglog(Integer idUserChgLog, String matricula, Date dateUserChg) {
		this.idUserChgLog = idUserChgLog;
		this.matricula = matricula;
		this.dateUserChg = dateUserChg;
	}

	public Integer getIdUserChgLog() {
		return this.idUserChgLog;
	}

	public void setIdUserChgLog(Integer idUserChgLog) {
		this.idUserChgLog = idUserChgLog;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDateUserChg() {
		return this.dateUserChg;
	}

	public void setDateUserChg(Date dateUserChg) {
		this.dateUserChg = dateUserChg;
	}

	public String getUsName() {
		return this.usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getUsLastName() {
		return this.usLastName;
	}

	public void setUsLastName(String usLastName) {
		this.usLastName = usLastName;
	}

	public String getUsAddress() {
		return this.usAddress;
	}

	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}

	public String getUsMail() {
		return this.usMail;
	}

	public void setUsMail(String usMail) {
		this.usMail = usMail;
	}

	public String getUsPhone() {
		return this.usPhone;
	}

	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}

	public Users getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Users idUser) {
		this.idUser = idUser;
	}

	public Installations getIdInst() {
		return this.idInst;
	}

	public void setIdInst(Installations idInst) {
		this.idInst = idInst;
	}

	public Wsautresulttype getIdResultType() {
		return this.idResultType;
	}

	public void setIdResultType(Wsautresulttype idResultType) {
		this.idResultType = idResultType;
	}

	public Wsautactiontype getIdActionType() {
		return this.idActionType;
	}

	public void setIdActionType(Wsautactiontype idActionType) {
		this.idActionType = idActionType;
	}

	@XmlTransient
	public Collection<Wsautuserdatachg> getWsautuserdatachgCollection() {
		return this.wsautuserdatachgCollection;
	}

	public void setWsautuserdatachgCollection(Collection<Wsautuserdatachg> wsautuserdatachgCollection) {
		this.wsautuserdatachgCollection = wsautuserdatachgCollection;
	}

	public int hashCode() {
		int hash = 0;
		hash += (this.idUserChgLog != null) ? this.idUserChgLog.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.wsusersinstaut.entity.Wsautuserschglog)) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.Wsautuserschglog other = (com.securitasdirect.wsusersinstaut.entity.Wsautuserschglog) object;
		if ((this.idUserChgLog == null && other.idUserChgLog != null)
				|| (this.idUserChgLog != null && !this.idUserChgLog.equals(other.idUserChgLog))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.Wsautuserschglog[ idUserChgLog=" + this.idUserChgLog + " ]";
	}
}

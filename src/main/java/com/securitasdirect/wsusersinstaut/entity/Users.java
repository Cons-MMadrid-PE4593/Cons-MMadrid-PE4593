package com.securitasdirect.wsusersinstaut.entity;

import com.securitasdirect.wsusersinstaut.entity.UsersPK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
		@NamedQuery(name = "Users.findByIdCountry", query = "SELECT u FROM Users u WHERE u.usersPK.idCountry = :idCountry"),
		@NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.usersPK.login = :login and u.usersPK.idCountry= :idCountry"),
		@NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
		@NamedQuery(name = "Users.findUserById", query = "SELECT u FROM Users u WHERE u.idUser = :idUser"),
		@NamedQuery(name = "Users.findByIdUser", query = "SELECT u FROM Users u WHERE u.idUser = :idUser or u.mainUser = :idUser"),
		@NamedQuery(name = "Users.findUniqueByIdUserIdCountry", query = "SELECT u FROM Users u WHERE u.idUser = :idUser and u.usersPK.idCountry=:idCountry"),
		@NamedQuery(name = "Users.findByIdLanguage", query = "SELECT u FROM Users u WHERE u.idLanguage = :idLanguage"),
		@NamedQuery(name = "Users.findByMainUser", query = "SELECT u FROM Users u WHERE u.mainUser = :mainUser"),
		@NamedQuery(name = "Users.findByBlocked", query = "SELECT u FROM Users u WHERE u.blocked = :blocked"),
		@NamedQuery(name = "Users.findByTrialsCounter", query = "SELECT u FROM Users u WHERE u.trialsCounter = :trialsCounter"),
		@NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
		@NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
		@NamedQuery(name = "Users.findByPinBloqueo", query = "SELECT u FROM Users u WHERE u.pinBloqueo = :pinBloqueo"),
		@NamedQuery(name = "Users.findByLegalsCondAccepted", query = "SELECT u FROM Users u WHERE u.legalsCondAccepted = :legalsCondAccepted"),
		@NamedQuery(name = "Users.findByLastPasswordReset", query = "SELECT u FROM Users u WHERE u.lastPasswordReset = :lastPasswordReset"),
		@NamedQuery(name = "Users.findByOperationalCode", query = "SELECT u FROM Users u WHERE u.operationalCode = :operationalCode"),
		@NamedQuery(name = "Users.unblock", query = "UPDATE Users u SET u.trialsCounter=0, u.blocked=FALSE WHERE u.idUser = :idUser"),
		@NamedQuery(name = "Users.editLogin", query = "UPDATE Users u SET u.usersPK.login =? WHERE u.idUser = :idUser"),
		@NamedQuery(name = "Users.findByUserCreationDate", query = "SELECT u FROM Users u WHERE u.userCreationDate = :userCreationDate") })
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected UsersPK usersPK;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 32)
	@Column(name = "password")
	private String password;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idUser")
	private int idUser;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idLanguage")
	private int idLanguage;
	@Basic(optional = false)
	@NotNull
	@Column(name = "mainUser")
	private int mainUser;
	@Basic(optional = false)
	@NotNull
	@Column(name = "blocked")
	private boolean blocked;
	@Basic(optional = false)
	@NotNull
	@Column(name = "trialsCounter")
	private int trialsCounter;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 16)
	@Column(name = "phone")
	private String phone;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "email")
	private String email;
	@Size(max = 32)
	@Column(name = "pinBloqueo")
	private String pinBloqueo;
	@Basic(optional = false)
	@NotNull
	@Column(name = "legalsCondAccepted")
	private boolean legalsCondAccepted;
	@Basic(optional = false)
	@NotNull
	@Column(name = "lastPasswordReset")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastPasswordReset;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 32)
	@Column(name = "operationalCode")
	private String operationalCode;
	@Basic(optional = false)
	@NotNull
	@Column(name = "userCreationDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date userCreationDate;

	public Users() {
	}

	public Users(UsersPK usersPK) {
		this.usersPK = usersPK;
	}

	public Users(UsersPK usersPK, String password, int idUser, int idLanguage, int mainUser, boolean blocked,
			int trialsCounter, String phone, String email, boolean legalsCondAccepted, Date lastPasswordReset,
			String operationalCode, Date userCreationDate) {
		this.usersPK = usersPK;
		this.password = password;
		this.idUser = idUser;
		this.idLanguage = idLanguage;
		this.mainUser = mainUser;
		this.blocked = blocked;
		this.trialsCounter = trialsCounter;
		this.phone = phone;
		this.email = email;
		this.legalsCondAccepted = legalsCondAccepted;
		this.lastPasswordReset = lastPasswordReset;
		this.operationalCode = operationalCode;
		this.userCreationDate = userCreationDate;
	}

	public Users(int idCountry, String login) {
		this.usersPK = new UsersPK(idCountry, login);
	}

	public UsersPK getUsersPK() {
		return this.usersPK;
	}

	public void setUsersPK(UsersPK usersPK) {
		this.usersPK = usersPK;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdLanguage() {
		return this.idLanguage;
	}

	public void setIdLanguage(int idLanguage) {
		this.idLanguage = idLanguage;
	}

	public int getMainUser() {
		return this.mainUser;
	}

	public void setMainUser(int mainUser) {
		this.mainUser = mainUser;
	}

	public boolean getBlocked() {
		return this.blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public int getTrialsCounter() {
		return this.trialsCounter;
	}

	public void setTrialsCounter(int trialsCounter) {
		this.trialsCounter = trialsCounter;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPinBloqueo() {
		return this.pinBloqueo;
	}

	public void setPinBloqueo(String pinBloqueo) {
		this.pinBloqueo = pinBloqueo;
	}

	public boolean getLegalsCondAccepted() {
		return this.legalsCondAccepted;
	}

	public void setLegalsCondAccepted(boolean legalsCondAccepted) {
		this.legalsCondAccepted = legalsCondAccepted;
	}

	public Date getLastPasswordReset() {
		return this.lastPasswordReset;
	}

	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	public String getOperationalCode() {
		return this.operationalCode;
	}

	public void setOperationalCode(String operationalCode) {
		this.operationalCode = operationalCode;
	}

	public Date getUserCreationDate() {
		return this.userCreationDate;
	}

	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	public int hashCode() {
		int hash = 0;
		hash += (this.usersPK != null) ? this.usersPK.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.wsusersinstaut.entity.Users)) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.Users other = (com.securitasdirect.wsusersinstaut.entity.Users) object;
		if ((this.usersPK == null && other.usersPK != null)
				|| (this.usersPK != null && !this.usersPK.equals(other.usersPK))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.Users[ usersPK=" + this.usersPK + " ]";
	}
}

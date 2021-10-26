package com.securitasdirect.wsusersinstaut.util.beans;

import com.securitasdirect.wsusersinstaut.entity.Users;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
public class UserInst implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean blocked;
	private String email;
	private int idLanguage;
	private int idUser;
	private Date lastPasswordReset;
	private boolean legalsCondAccepted;
	private int mainUser;
	private String operationalCode;
	private String phone;
	private String pinBloqueo;
	private int trialsCounter;
	private Date userCreationDate;
	private String login;
	private String installations;

	public static long getSerialVersionUID() {
		return 1L;
	}

	@XmlElement(name = "blocked")
	public boolean getBlocked() {
		return this.blocked;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return this.email;
	}

	@XmlElement(name = "idLanguage")
	public int getIdLanguage() {
		return this.idLanguage;
	}

	@XmlElement(name = "idUser")
	public int getIdUser() {
		return this.idUser;
	}

	@XmlElement(name = "lastPasswordReset")
	public Date getLastPasswordReset() {
		return this.lastPasswordReset;
	}

	@XmlElement(name = "legalsCondAccepted")
	public boolean getLegalsCondAccepted() {
		return this.legalsCondAccepted;
	}

	@XmlElement(name = "mainUser")
	public int getMainUser() {
		return this.mainUser;
	}

	@XmlElement(name = "operationalCode")
	public String getOperationalCode() {
		return this.operationalCode;
	}

	@XmlElement(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	@XmlElement(name = "pinBloqueo")
	public String getPinBloqueo() {
		return this.pinBloqueo;
	}

	@XmlElement(name = "trialsCounter")
	public int getTrialsCounter() {
		return this.trialsCounter;
	}

	@XmlElement(name = "userCreationDate")
	public Date getUserCreationDate() {
		return this.userCreationDate;
	}

	@XmlElement(name = "login")
	public String getLogin() {
		return this.login;
	}

	@XmlElement(name = "installations")
	public String getInstallations() {
		return this.installations;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdLanguage(int idLanguage) {
		this.idLanguage = idLanguage;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setLastPasswordReset(Date lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	public void setLegalsCondAccepted(boolean legalsCondAccepted) {
		this.legalsCondAccepted = legalsCondAccepted;
	}

	public void setMainUser(int mainUser) {
		this.mainUser = mainUser;
	}

	public void setOperationalCode(String operationalCode) {
		this.operationalCode = operationalCode;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPinBloqueo(String pinBloqueo) {
		this.pinBloqueo = pinBloqueo;
	}

	public void setTrialsCounter(int trialsCounter) {
		this.trialsCounter = trialsCounter;
	}

	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setInstallations(String installations) {
		this.installations = installations;
	}

	public int hashCode() {
		int hash = 5;
		return hash;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.util.beans.UserInst other = (com.securitasdirect.wsusersinstaut.util.beans.UserInst) obj;
		return true;
	}

	public String toString() {
		return "UserInst{blocked=" + this.blocked + ", email=" + this.email + ", idLanguage=" + this.idLanguage
				+ ", idUser=" + this.idUser + ", lastPasswordReset=" + this.lastPasswordReset + ", legalsCondAccepted="
				+ this.legalsCondAccepted + ", mainUser=" + this.mainUser + ", operationalCode=" + this.operationalCode
				+ ", phone=" + this.phone + ", pinBloqueo=" + this.pinBloqueo + ", trialsCounter=" + this.trialsCounter
				+ ", userCreationDate=" + this.userCreationDate + ", login=" + this.login + ", installations="
				+ this.installations + '}';
	}

	public static com.securitasdirect.wsusersinstaut.util.beans.UserInst convertUsersToUserInst(Users userBD) {
		com.securitasdirect.wsusersinstaut.util.beans.UserInst userResp = new com.securitasdirect.wsusersinstaut.util.beans.UserInst();
		userResp.setBlocked(userBD.getBlocked());
		userResp.setEmail(userBD.getEmail());
		userResp.setIdLanguage(userBD.getIdLanguage());
		userResp.setIdUser(userBD.getIdUser());
		userResp.setLastPasswordReset(userBD.getLastPasswordReset());
		userResp.setLegalsCondAccepted(userBD.getLegalsCondAccepted());
		userResp.setLogin(userBD.getUsersPK().getLogin());
		userResp.setMainUser(userBD.getMainUser());
		userResp.setOperationalCode(userBD.getOperationalCode());
		userResp.setPhone(userBD.getPhone());
		userResp.setPinBloqueo(userBD.getPinBloqueo());
		userResp.setTrialsCounter(userBD.getTrialsCounter());
		userResp.setUserCreationDate(userBD.getUserCreationDate());
		return userResp;
	}
}

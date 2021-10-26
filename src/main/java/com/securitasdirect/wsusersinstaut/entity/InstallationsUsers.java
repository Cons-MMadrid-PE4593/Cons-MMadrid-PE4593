package com.securitasdirect.wsusersinstaut.entity;

import com.securitasdirect.wsusersinstaut.entity.InstallationsUsersPK;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "installationsUsers")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "InstallationsUsers.findByIdUser", query = "SELECT iu FROM InstallationsUsers iu WHERE iu.instsUsersPK.idUser = :userid order by iu.instsUsersPK.idInst"),
		@NamedQuery(name = "InstallationsUsers.findByIdInstallation", query = "SELECT iu FROM InstallationsUsers iu WHERE iu.instsUsersPK.idInst = :installationid") })
public class InstallationsUsers implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected InstallationsUsersPK instsUsersPK;

	public InstallationsUsers() {
	}

	public InstallationsUsers(InstallationsUsersPK instsUsersPK) {
		this.instsUsersPK = instsUsersPK;
	}

	public InstallationsUsers(int idInst, int idUser) {
		this.instsUsersPK = new InstallationsUsersPK(idInst, idUser);
	}

	public InstallationsUsersPK getInstsUsersPK() {
		return this.instsUsersPK;
	}

	public void setInstsUsersPK(InstallationsUsersPK instsUsersPK) {
		this.instsUsersPK = instsUsersPK;
	}

	public int hashCode() {
		int hash = 7;
		hash = 13 * hash + ((this.instsUsersPK != null) ? this.instsUsersPK.hashCode() : 0);
		return hash;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		com.securitasdirect.wsusersinstaut.entity.InstallationsUsers other = (com.securitasdirect.wsusersinstaut.entity.InstallationsUsers) obj;
		if (this.instsUsersPK != other.instsUsersPK
				&& (this.instsUsersPK == null || !this.instsUsersPK.equals(other.instsUsersPK))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "InstallationsUsers{instsUsersPK=" + this.instsUsersPK + '}';
	}
}

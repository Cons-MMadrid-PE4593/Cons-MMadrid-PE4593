package com.securitasdirect.wsusersinstaut.util.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SESSION")
public class ResponseValidatorSessions {
	private String valide;

	@XmlElement(name = "RESULT")
	public String getValide() {
		return this.valide;
	}

	public void setValide(String valide) {
		this.valide = valide;
	}
}

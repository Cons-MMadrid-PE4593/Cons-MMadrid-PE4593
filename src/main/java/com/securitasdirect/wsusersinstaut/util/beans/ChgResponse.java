package com.securitasdirect.wsusersinstaut.util.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CHGRESPONSE")
public class ChgResponse {
	private String response;
	private String message;

	@XmlElement(name = "MESSAGE")
	public String getMessage() {
		return this.message;
	}

	@XmlElement(name = "RESPONSE")
	public String getResponse() {
		return this.response;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}

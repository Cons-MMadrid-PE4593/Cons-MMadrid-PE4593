package com.securitasdirect.wsusersinstaut.util.beans;

public class SecondUserToMain {
	private int secondUserId;
	private int mainUserId;
	private String useratc;
	private String codeword;

	public int getSecondUserId() {
		return this.secondUserId;
	}

	public void setSecondUserId(int secondUserId) {
		this.secondUserId = secondUserId;
	}

	public int getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(int mainUserId) {
		this.mainUserId = mainUserId;
	}

	public String getUseratc() {
		return this.useratc;
	}

	public void setUseratc(String useratc) {
		this.useratc = useratc;
	}

	public String getCodeword() {
		return this.codeword;
	}

	public void setCodeword(String codeword) {
		this.codeword = codeword;
	}
}

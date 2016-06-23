package com.barclays.chat.requestModel;

public class NomiCustomerInfo {
	/**
	 *
	 */
	private String custName="";
	private String acctNum;
	private String sortCode;
	private String cisId;
	private String channel;
	private String efIdentifier;
	private String aid;
	private String acctType;
	private String phoneNumber;
	private String appId;
	private String csrfToken; //used to avoid forgery attack
	
	private String email;
	private String firstName;
	private String surName;
	private String salutation;
	private String existingAccount;
	private String errorCode;
	private String jSessionId;
	private String question;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getExistingAccount() {
		return existingAccount;
	}
	public void setExistingAccount(String existingAccount) {
		this.existingAccount = existingAccount;
	}
	public String getCsrfToken() {
		return csrfToken;
	}
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}

	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getCisId() {
		return cisId;
	}
	public void setCisId(String cisId) {
		this.cisId = cisId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
/*	public String getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(String authLevel) {
		this.authLevel = authLevel;
	}
*/
	
	public String getAcctType() {
		return acctType;
	}
	public String getEfIdentifier() {
		return efIdentifier;
	}
	public void setEfIdentifier(String efIdentifier) {
		this.efIdentifier = efIdentifier;
	}
	public String getjSessionId() {
		return jSessionId;
	}
	public void setjSessionId(String jSessionId) {
		this.jSessionId = jSessionId;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return ("[Customer Name= " + custName + ", channel= " + channel + ", cisId= " + cisId + ", efIdentifier= "
				+ efIdentifier + ", appId= "
				+ appId + ", phoneNumber= " + phoneNumber + "]");
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
}

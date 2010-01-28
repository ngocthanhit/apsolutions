package com.bke2.util;

import java.util.Date;

public class VendorRet {
	private String listID;
	private String timeCreated;
	private String timeModified;
	private String termsRef="";
	private String name="";
	private String isInActive;
	private String accountNumber;
	private String companyName;
	private String type="";
	private String creditLimit="";
	private String quickBasePrimaryKey="";
	
	public String getListID() {
		return listID;
	}
	public void setListID(String listID) {
		this.listID = listID;
	}
	public String getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	public String getTimeModified() {
		return timeModified;
	}
	public void setTimeModified(String timeModified) {
		this.timeModified = timeModified;
	}
	public String getTermsRef() {
		return termsRef;
	}
	public void setTermsRef(String termsRef) {
		this.termsRef = termsRef;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsInActive() {
		return isInActive;
	}
	public void setIsInActive(String isActive) {
		this.isInActive = isActive;
	}
	public String getAccountNumber(){
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
    public String toString() {
		
		String aa="";
		aa=" ListId:"+listID+"\n";
		aa=aa+"TimeModified:"+timeModified+"\n";
		aa=aa+"TermsRef:"+termsRef+"\n";
		aa=aa+"Type:"+type+"\n";
		aa=aa+"IsInActive:"+isInActive+"\n";
		aa=aa+"CreditLimit:"+creditLimit+"\n";
		aa=aa+"Name:"+name+"\n";
		aa=aa+"CompanyName:"+companyName+"\n";
		aa=aa+"Account:"+accountNumber+"\n";
		aa=aa+"QuickBasePrimaryKey:"+quickBasePrimaryKey+"\n";
		return aa;
	}
	public String getQuickBasePrimaryKey() {
		return quickBasePrimaryKey;
	}
	public void setQuickBasePrimaryKey(String quickBasePrimaryKey) {
		this.quickBasePrimaryKey = quickBasePrimaryKey;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}


package com.bke2.util;

public class AccountRet {
	private String listId = null;
	private String timeCreated = null;
	private String timeModified = null;
	private String editSequence = null;
	private String name = null;
	private String isInActive = null;
	private String sublevel = null;
	private String accountType = null;
	private String desc = null;
	private String balance = null;
	private String totalBalance = null;
	private String fullName = null;
	private String accountNumber = null;
	private String quickBasePrimaryKey = null;
	
	public String getQuickBasePrimaryKey() {
		return quickBasePrimaryKey;
	}
	public void setQuickBasePrimaryKey(String quickBasePrimaryKey) {
		this.quickBasePrimaryKey = quickBasePrimaryKey;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
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
	public String getEditSequence() {
		return editSequence;
	}
	public void setEditSequence(String editSequence) {
		this.editSequence = editSequence;
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
	public void setIsInActive(String isInActive) {
		//System.out.println("Is Active >>>>>>>>>>>>>>"+ isInActive);
		this.isInActive = isInActive;
	}
	public String getSublevel() {
		return sublevel;
	}
	public void setSublevel(String sublevel) {
		this.sublevel = sublevel;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(String totalBalance) {
		this.totalBalance = totalBalance;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String toString() {
		
		String aa="";
		aa=" ListId:"+listId+"\n";
		aa=aa+"TimeCreated:"+timeCreated+"\n";
		aa=aa+"TimeModified:"+timeModified+"\n";
		aa=aa+"EditSequence:"+editSequence+"\n";
		aa=aa+"Name:"+name+"\n";
		aa=aa+"IsInActive:"+isInActive+"\n";
		aa=aa+"Sublevel:"+sublevel+"\n";
		aa=aa+"AccountType:"+accountType+"\n";
		aa=aa+"Description:"+desc+"\n";
		aa=aa+"Balance:"+balance+"\n";
		aa=aa+"TotalBalance:"+totalBalance+"\n";
		aa=aa+"FullName:"+fullName+"\n";
		aa=aa+"AaccountNumber:"+accountNumber+"\n";
		aa=aa+"QuickBasePrimaryKey:"+quickBasePrimaryKey+"\n\n\n";
		return aa;
	}
}

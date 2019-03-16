package com.zyp.entity;

public class User {
    private int uId;
    private String uName;
    private String uPass;
    private double balance;
    private int uType;
   
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int uId, String uName, String uPass, double balance, int uType) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPass = uPass;
		this.balance = balance;
		this.uType = uType;
	}

	public User(String uName, String uPass, int uType) {
		super();
		this.uName = uName;
		this.uPass = uPass;
		this.uType = uType;
	}

	public User(String uName, String uPass, double balance) {
		super();
		this.uName = uName;
		this.uPass = uPass;
		this.balance = balance;
	}
	public User(String uName, String uPass, double balance, int uType) {
		super();
		this.uName = uName;
		this.uPass = uPass;
		this.balance = balance;
		this.uType = uType;
	}
	public int getUid() {
		return uId;
	}
	public void setUid(int uid) {
		this.uId = uid;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getuType() {
		return uType;
	}
	public void setuType(int uType) {
		this.uType = uType;
	}
	@Override
	public String toString() {
		return "User [uid=" + uId + ", uName=" + uName + ", uPass=" + uPass + ", balance=" + balance + ", uType="
				+ uType + "]";
	}
    
}

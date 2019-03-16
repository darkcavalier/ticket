package com.zyp.entity;

public class Hall {
	private int hId;
	private String hName;
	private int cId;
	private int capacity;

	public Hall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hall(String hName, int cId, int capacity) {
		super();
		this.hName = hName;
		this.cId = cId;
		this.capacity = capacity;
	}

	public Hall(int hId, String hName, int cId, int capacity) {
		super();
		this.hId = hId;
		this.hName = hName;
		this.cId = cId;
		this.capacity = capacity;
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Hall [hId=" + hId + ", hName=" + hName + ", cId=" + cId + ", capacity=" + capacity + "]";
	}

	

	
	

}

package com.zyp.entity;

public class Ticket {
	int tId;
	int uId;
	int sId;
	int seat;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(int uId, int sId, int seat) {
		super();
		this.uId = uId;
		this.sId = sId;
		this.seat = seat;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Ticket [tId=" + tId + ", uId=" + uId + ", sId=" + sId + ", seat=" + seat + "]";
	}

	
 
}

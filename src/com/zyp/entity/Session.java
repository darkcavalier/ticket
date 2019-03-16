package com.zyp.entity;

import java.util.Date;

public class Session {
	int sId;
	int hId;
	int cId;
	int mId;
	Date beginTime;
	double price;
	int remain;

	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	




	public Session(int hId, int cId, Date beginTime, double price, int remain) {
		super();
		this.hId = hId;
		this.cId = cId;
		this.beginTime = beginTime;
		this.price = price;
		this.remain = remain;
	}





	public Session(int sId) {
		super();
		this.sId = sId;
	}





	public Session(int hId, int cId, int mId, Date beginTime, double price, int remain) {
		super();
		this.hId = hId;
		this.cId = cId;
		this.mId = mId;
		this.beginTime = beginTime;
		this.price = price;
		this.remain = remain;
	}





	public Session(int sId, int hId, int cId, int mId, Date beginTime, double price, int remain) {
		super();
		this.sId = sId;
		this.hId = hId;
		this.cId = cId;
		this.mId = mId;
		this.beginTime = beginTime;
		this.price = price;
		this.remain = remain;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	

	public Date getBeginTime() {
		return beginTime;
	}


	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}


	@Override
	public String toString() {
		return "Session [sId=" + sId + ", hId=" + hId + ", cId=" + cId + ", mId=" + mId + ", beginTime=" + beginTime
				+ ", price=" + price + ", remain=" + remain + "]";
	}

}

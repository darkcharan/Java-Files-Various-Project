package com.Shopingcart.admin.bean;

import java.io.Serializable;

public class Mobile implements Serializable{
	private int mno;
	private String mname;
	private double price;
	private int qty;
	public Mobile(int mno, String mname, double price, int qty) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.price = price;
		this.qty = qty;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "" + mno + "\t" + mname + "\t" + price + "\t" + qty + "";
	}
	
	
	

}

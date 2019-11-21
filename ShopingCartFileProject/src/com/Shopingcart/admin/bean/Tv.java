package com.Shopingcart.admin.bean;

import java.io.Serializable;

public class Tv implements Serializable{
	public int tvno;
	public String tname;
	public double price;
	public int qty;
	public Tv(int tvno, String tname, double price, int qty) {
		super();
		this.tvno = tvno;
		this.tname = tname;
		this.price = price;
		this.qty = qty;
	}
	public int getTvno() {
		return tvno;
	}
	public void setTvno(int tvno) {
		this.tvno = tvno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
		return "" + tvno + "\t" + tname + "\t" + price + "\t" + qty + "";
	}
	
	
	
	

}

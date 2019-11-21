package com.Shopingcart.admin.bean;

import java.io.Serializable;

public class Computer implements Serializable{
	private int cno;
	private String cnmae;
	private double cprice;
	private int cqnty;
	public Computer(int cno, String cnmae, double cprice, int cqnty) {
		super();
		this.cno = cno;
		this.cnmae = cnmae;
		this.cprice = cprice;
		this.cqnty = cqnty;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCnmae() {
		return cnmae;
	}
	public void setCnmae(String cnmae) {
		this.cnmae = cnmae;
	}
	public double getCprice() {
		return cprice;
	}
	public void setCprice(double cprice) {
		this.cprice = cprice;
	}
	public int getCqnty() {
		return cqnty;
	}
	public void setCqnty(int cqnty) {
		this.cqnty = cqnty;
	}
	@Override
	public String toString() {
		return "" + cno + "\t" + cnmae + "\t" + cprice + "\t" + cqnty + "";
	}
	
	

}

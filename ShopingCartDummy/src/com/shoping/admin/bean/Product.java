package com.shoping.admin.bean;

import java.io.Serializable;

public class Product implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int pid;
private String pname;
private double pprice;
private int pqty;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public double getPprice() {
	return pprice;
}
public void setPprice(double pprice) {
	this.pprice = pprice;
}
public int getPqty() {
	return pqty;
}
public void setPqty(int pqty) {
	this.pqty = pqty;
}
public Product(int pid, String pname, double pprice, int pqty) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.pprice = pprice;
	this.pqty = pqty;
}
@Override
public String toString() {
	return "" + pid + "\t" + pname + "\t" + pprice
			+ "\t" + pqty + "\t";
}

}

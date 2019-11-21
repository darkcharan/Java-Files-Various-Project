package com.Shopingcart.admin.bean;

import java.io.Serializable;

public class Customer implements Serializable {
private String cname;
private String pwd;
private long mobileNumber;
public Customer(String cname, String pwd, long mobileNumber) {
	super();
	this.cname = cname;
	this.pwd = pwd;
	this.mobileNumber = mobileNumber;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
@Override
public String toString() {
	return "" + cname + "\t" + pwd + "\t" + mobileNumber + "";
}

}

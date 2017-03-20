package model;

import java.util.ArrayList;
import java.util.List;


public class Order {
	   int id;
	   int userid;
	   int ordername;
	   double totalprice;
	   int payornot=0;
	public Order(int id, int userid, int ordername, float totalprice,
			int payornot) {
		super();
		this.id = id;
		this.userid = userid;
		this.ordername = ordername;
		this.totalprice = totalprice;
		this.payornot = payornot;
	}
	
	public Order(int id, int userid, double d, int payornot) {
		super();
		this.id = id;
		this.userid = userid;
		this.totalprice = d;
		this.payornot = payornot;
	}

	public Order() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getOrdername() {
		return ordername;
	}
	public void setOrdername(int ordername) {
		this.ordername = ordername;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public int getPayornot() {
		return payornot;
	}
	public void setPayornot(int payornot) {
		this.payornot = payornot;
	}

 
}

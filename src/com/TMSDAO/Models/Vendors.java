package com.TMSDAO.Models;

public class Vendors {
	private int vendorId;
	private String vendorPassword;
	private String vendorname;
	private String vendorEmail;
	private String vendorPhone;

	

	@Override
	public String toString() {
		return "Vendors [vendorId=" + vendorId + ", vendorPassword=" + vendorPassword + ", vendorname=" + vendorname
				+ ", vendorEmail=" + vendorEmail + ", vendorPhone=" + vendorPhone + "]";
	}

	public Vendors(int i, String vendorPassword, String vendorname, String vendorEmail, String vendorPhone) {
		super();
		this.vendorId = i;
		this.vendorPassword = vendorPassword;
		this.vendorname = vendorname;
		this.vendorEmail = vendorEmail;
		this.vendorPhone = vendorPhone;
	}
	

	public Vendors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  int getVendorId() {
		return vendorId;
	}

	public  void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public  String getVendorPassword() {
		return vendorPassword;
	}

	public void setVendorPassword(String vendorPassword) {
		this.vendorPassword = vendorPassword;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

}

package com.TMSDAO.Models;

public class Admin {
	private int adminId;
	private String AdminPassword;
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", AdminPassword=" + AdminPassword + "]";
	}
	public Admin(int adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		AdminPassword = adminPassword;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
		public Admin() {
		// TODO Auto-generated constructor stub
	}

}

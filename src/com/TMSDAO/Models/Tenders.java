package com.TMSDAO.Models;

public class Tenders {
	private int tenderId;
	private String tenderTitle;
	private String tenderdescription;
	private int tenderPrice;
	
	@Override
	public String toString() {
		return "Tenders [tenderId=" + tenderId + ", tenderTitle=" + tenderTitle + ", tenderdescription="
				+ tenderdescription + ", tenderPrice=" + tenderPrice + ", tenderStatus=" + tenderStatus + "]";
	}
	public int getTenderId() {
		return tenderId;
	}
	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}
	public String getTenderTitle() {
		return tenderTitle;
	}
	public void setTenderTitle(String tenderTitle) {
		this.tenderTitle = tenderTitle;
	}
	public String getTenderdescription() {
		return tenderdescription;
	}
	public void setTenderdescription(String tenderdescription) {
		this.tenderdescription = tenderdescription;
	}
	public int getTenderPrice() {
		return tenderPrice;
	}
	public void setTenderPrice(int tenderPrice) {
		this.tenderPrice = tenderPrice;
	}
	public String getTenderStatus() {
		return tenderStatus;
	}
	public void setTenderStatus(String tenderStatus) {
		this.tenderStatus = tenderStatus;
	}
	public Tenders(int tenderId, String tenderTitle, String tenderdescription, int tenderPrice, String tenderStatus) {
		super();
		this.tenderId = tenderId;
		this.tenderTitle = tenderTitle;
		this.tenderdescription = tenderdescription;
		this.tenderPrice = tenderPrice;
		this.tenderStatus = tenderStatus;
	}
	private String tenderStatus;
	public Tenders() {
		// TODO Auto-generated constructor stub
	}

}

package com.TMSDAO.Models;

public class Bids {
	
	private int bidId;
	private int vendorId;
	private int tenderId;
	private int bidAmount;
	private String submission_details;
	private String bidStatus;
	public Bids(int bidId, int vendorId, int tenderId, int bidAmount, String submission_details, String bidStatus) {
		super();
		this.bidId = bidId;
		this.vendorId = vendorId;
		this.tenderId = tenderId;
		this.bidAmount = bidAmount;
		this.submission_details = submission_details;
		this.bidStatus = bidStatus;
	}
	@Override
	public String toString() {
		return "Bids [bidId=" + bidId + ", vendorId=" + vendorId + ", tenderId=" + tenderId + ", bidAmount=" + bidAmount
				+ ", submission_details=" + submission_details + ", bidStatus=" + bidStatus + "]";
	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getTenderId() {
		return tenderId;
	}
	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
	public String getSubmission_details() {
		return submission_details;
	}
	public void setSubmission_details(String submission_details) {
		this.submission_details = submission_details;
	}
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

}

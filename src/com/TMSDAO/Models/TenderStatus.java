package com.TMSDAO.Models;

public class TenderStatus {
	private int tenderId;
	private int vendorId;
	private String status;
	private int bidId;

	@Override
	public String toString() {
		return "TenderStatus [tenderId=" + tenderId + ", vendorId=" + vendorId + ", status=" + status + ", bidId="
				+ bidId + "]";
	}

	public TenderStatus(int tenderId, int vendorId, String status, int bidId) {
		super();
		this.tenderId = tenderId;
		this.vendorId = vendorId;
		this.status = status;
		this.bidId = bidId;
	}

	public int getTenderId() {
		return tenderId;
	}

	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public TenderStatus() {
		// TODO Auto-generated constructor stub
	}

}

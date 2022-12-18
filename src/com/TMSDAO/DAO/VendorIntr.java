package com.TMSDAO.DAO;

import java.util.List;

import com.TMSDAO.Exceptions.*;
import com.TMSDAO.Models.*;

public interface VendorIntr {
public Vendors loginVendor(String userName,String password)throws VenderException;
	
	
	public List<Tenders> getAvailableTendersList()throws TenderException;
	
	public String bidAgainstaTender(int tenderId,int vendorId,int bidAmount,String submission_details)throws BidsException,TenderException;
	
	public String statusOfBid(int bidAmount) throws BidsException;
	
	
	public List<Bids> vendorBidHistory(int vendorId)throws BidsException;

}

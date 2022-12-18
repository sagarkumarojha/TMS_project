package com.TMSDAO.DAO;

import java.util.List;

import com.TMSDAO.Exceptions.AdminException;
import com.TMSDAO.Exceptions.BidsException;
import com.TMSDAO.Exceptions.TenderException;
import com.TMSDAO.Exceptions.VenderException;
import com.TMSDAO.Models.Bids;
import com.TMSDAO.Models.Tenders;
import com.TMSDAO.Models.Vendors;

public interface AdminIntr {
public boolean adminLogin(String adminUserName, String adminPassword) throws AdminException;
	
	public String registerVender(Vendors vendor)throws VenderException;
	
	public List<Vendors> getAllVender()throws VenderException;
	
	public String addNewTender(Tenders tender)throws TenderException;
	
	public List<Tenders> getAllTender()throws TenderException;
	
	public List<Bids> getAllBids()throws BidsException;
	
	public List<Bids> getAllBidsOfTender(int tenderId)throws BidsException;
	
	public String assignTendor(int tendorId,int vendorId,int bidderId)throws TenderException , VenderException, BidsException;
}

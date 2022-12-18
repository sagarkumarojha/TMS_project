package com.TMSDAO.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TMSDAO.Exceptions.AdminException;
import com.TMSDAO.Exceptions.BidsException;
import com.TMSDAO.Exceptions.TenderException;
import com.TMSDAO.Exceptions.VenderException;
import com.TMSDAO.Models.Bids;
import com.TMSDAO.Models.Tenders;
import com.TMSDAO.Models.Vendors;
import com.TMSDAO.Utilities.SqlConnect;

public class AdminIntrImpl implements AdminIntr{

	public AdminIntrImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean adminLogin(String adminUserName, String adminPassword) throws AdminException {
		// TODO Auto-generated method stub
		boolean b = false;

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con
					.prepareStatement("select * from Admin where adminUserName=? AND adminPassword=?");
			ps.setString(1, adminUserName);
			ps.setString(2, adminPassword);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				b = true;
			} else {
				throw new AdminException("Wrong Username or Password...");
			}

		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}

		return b;
	}

	@Override
	public String registerVender(Vendors vendor) throws VenderException {
		// TODO Auto-generated method stub
		String str = "Not inserted";

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"insert into vendors(vendorId,vendorname,vendorPassword,vendorPhone,vendorEmail) values(?,?,?,?,?)");

			ps.setInt(1, vendor.getVendorId());
			ps.setString(2, vendor.getVendorname());
			ps.setString(3, vendor.getVendorPassword());
			ps.setString(4, vendor.getVendorPhone());
            ps.setString(5, vendor.getVendorEmail());
			
			int x = ps.executeUpdate();

			if (x > 0) {
				str = "Vendor details inserted sucessfully...";
			} else {
				throw new VenderException("Vendor registration fail...");
			}

		} catch (SQLException e) {
			throw new VenderException(e.getMessage());
		}

		return str;
		
	}

	@Override
	public List<Vendors> getAllVender() throws VenderException {
		// TODO Auto-generated method stub
		List<Vendors> vendors = new ArrayList<>();

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from vendors");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				vendors.add(new Vendors(rs.getInt("vendorId"),rs.getString("vendorPassword"),rs.getString("vendorName"),rs.getString("vendorEmail"),rs.getString("vendorPhone")));
			}

			if (vendors.size() == 0) {
				throw new VenderException(" No Vendor");
			}

		} catch (SQLException e) {
			throw new VenderException(e.getMessage());
		}

		return vendors;
	}

	@Override
	public String addNewTender(Tenders tender) throws TenderException {
		// TODO Auto-generated method stub

		String str = "Tender details is not inserted";

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement(
					"insert into tenders(tenderTitle,tenderdescription,tenderPrice,tenderStatus) values(?,?,?,'open')");
			ps.setString(1, tender.getTenderTitle());
			ps.setString(2, tender.getTenderdescription());
			ps.setInt(3, tender.getTenderPrice());
			int x = ps.executeUpdate();

			if (x > 0) {
				str = "Tender details is inserted successfully...";
			} else {
				throw new TenderException("Tendor details inserted unsuccessful");
			}

		} catch (SQLException e) {
			throw new TenderException(e.getMessage());
		}

		return str;
	}

	@Override
	public List<Tenders> getAllTender() throws TenderException {
		// TODO Auto-generated method stub
		List<Tenders> tendors = new ArrayList<>();

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tenders");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tendors.add(new Tenders(rs.getInt("tenderId"),rs.getString("tenderTitle"), rs.getString("tenderdescription"), rs.getInt("tenderPrice"),
						rs.getString("tenderStatus")));
			}

			if (tendors.size() == 0) {
				throw new TenderException("Tendor list is empty!");
			}

		} catch (SQLException e) {
			throw new TenderException(e.getMessage());
		}

		return tendors;
	}

	@Override
	public List<Bids> getAllBids() throws BidsException {
		// TODO Auto-generated method stub
		List<Bids> bidder = new ArrayList<>();

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from bids");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bidder.add(new Bids(rs.getInt("bidId"),rs.getInt("vendorId"),rs.getInt("tenderId"),rs.getInt("bidAmount"),rs.getString("submission_details"),rs.getString("bidStatus")));
			}

			if (bidder.size() == 0) {
				throw new BidsException("Bid list is empty!");
			}

		} catch (SQLException e) {
			throw new BidsException(e.getMessage());
		}

		return bidder;

		
	}

	@Override
	public List<Bids> getAllBidsOfTender(int tenderId) throws BidsException {
		// TODO Auto-generated method stub
		List<Bids> bidder = new ArrayList<>();

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from bids where tenderId=?");
			ps.setInt(1,tenderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bidder.add(new Bids(rs.getInt("bidId"),rs.getInt("vendorId"),rs.getInt("tenderId"),rs.getInt("bidAmount"),rs.getString("bidStatus"),rs.getString("submission_details")));
			}

			if (bidder.size() == 0) {
				throw new BidsException("No Bids With this tenderId");
			}

		} catch (SQLException e) {
			throw new BidsException(e.getMessage());
		}

		return bidder;
	}

	@Override
	public String assignTendor(int tenderId, int vendorId, int bidId)
			throws TenderException, VenderException, BidsException {
		// TODO Auto-generated method stub
		String str="Not Assigned";
		try (Connection con = SqlConnect.provideConnection()){
			
			PreparedStatement ps =  con.prepareStatement("select * from tenderStatus where statusId=? AND vendorId=?");
			ps.setInt(1, tenderId);
			ps.setInt(2, vendorId);	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				 str = "Assigned already...";
			}else {
				PreparedStatement ps1 =  con.prepareStatement("insert into tenderStatus(statusId,tenderId,bidId,vendorId) values(?,?,?,'Selected')");
				ps1.setInt(1, tenderId);
				ps1.setInt(2, bidId);
				ps1.setInt(2, vendorId);
				
				int x = ps.executeUpdate();
				
				if(x>0) {
					   
						str = "Tendor "+tenderId+" assigned to a vendor "+vendorId;
						PreparedStatement ps2 =  con.prepareStatement("update bids set status = 'Selected' where tenderId=? And bidId=? AND vendorId=?");
						ps2.setInt(1, tenderId);
						ps2.setInt(2, bidId);
						ps2.setInt(3, vendorId);
						int y=ps2.executeUpdate();
						if(y>0) {
							PreparedStatement ps3 =  con.prepareStatement("update tenders set tenderStatus = 'Assigned' where tenderId=?");
						    ps3.setInt(1, tenderId);
							ps3.executeUpdate();	
						}
						
						
					
				}else {
					throw new TenderException("Tender is not available OR inputWrong");
					
				}
				
			}
			
		} catch (SQLException e) {
			throw new VenderException(e.getMessage());
		}
		
		return str;
	}

}

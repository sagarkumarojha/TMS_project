package com.TMSDAO.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TMSDAO.Exceptions.BidsException;
import com.TMSDAO.Exceptions.TenderException;
import com.TMSDAO.Exceptions.VenderException;
import com.TMSDAO.Models.Bids;
import com.TMSDAO.Models.Tenders;
import com.TMSDAO.Models.Vendors;
import com.TMSDAO.Utilities.SqlConnect;

public class VendorIntrImpl implements VendorIntr {

	public VendorIntrImpl() {
		// TODO Auto-generated constructor stub
		//99987667---1234
	}

	@Override
	public Vendors loginVendor(String userName, String password) throws VenderException {
		// TODO Auto-generated method stub
		Vendors vendor = null;

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con
					.prepareStatement("select * from vendors where vendorPhone=? AND vendorPassword=?");
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				vendor = new Vendors(rs.getInt("vendorId"), rs.getString("vendorPassword"), rs.getString("vendorName"), rs.getString("vendorEmail"),rs.getString("vendorPhone"));
			} else {
				throw new VenderException("Wrong Username or Password...");
			}

		} catch (SQLException e) {
			throw new VenderException(e.getMessage());
		}

		return vendor;
	}

	@Override
	public List<Tenders> getAvailableTendersList() throws TenderException {
		// TODO Auto-generated method stub
		List<Tenders> tenders = new ArrayList<>();

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from tenders where tenderStatus = 'open'");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tenders.add(new Tenders(rs.getInt("tenderId"), rs.getString("tenderTitle"),
						rs.getString("tenderdescription"), rs.getInt("tenderPrice"), rs.getString("tenderStatus")));
			}

			if (tenders.size() == 0) {
				throw new TenderException("No Available Tendor");
			}

		} catch (SQLException e) {
			throw new TenderException(e.getMessage());

		}

		return tenders;
	}

	@Override
	public String bidAgainstaTender(int tenderId, int vendorId, int bidAmount, String submission_details)
			throws BidsException, TenderException {
		// TODO Auto-generated method stub
		String str = "Something went wrong....";
		try (Connection con = SqlConnect.provideConnection()) {

			

			PreparedStatement ps = con.prepareStatement(
					"select * from tenders where tenderId=? and tenderStatus = 'Assigned'");
			ps.setInt(1, tenderId);

			ResultSet rs = ps.executeQuery();


			if (!rs.next()) {

					PreparedStatement ps1 = con.prepareStatement(
							"insert into bids(vendorId,tenderId,bidAmount,submission_details,bidStatus) values(?,?,?,?,'applied')");
					ps1.setInt(1, vendorId);
					ps1.setInt(2, tenderId);
					ps1.setInt(3, bidAmount);
					ps1.setString(4, submission_details);

					int x = ps1.executeUpdate();
					if (x > 0) {

							str = "Bid placed successfully";
						} else {
							throw new BidsException("Bid not placed ");
						}
			} else {
				
				throw new TenderException("tender is already bidded");
			}

		} catch (SQLException e) {
			throw new TenderException(e.getMessage());
		}

		return str;
	}

	@Override
	public String statusOfBid(int bid) throws BidsException {
		// TODO Auto-generated method stub
		String str = "No bids present";

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select bidStatus from bids where bidId=?");

			ps.setInt(1, bid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				str = rs.getString("bidStatus");
			} else {
				throw new BidsException("Tendor not found");
			}

		} catch (SQLException e) {
			throw new BidsException(e.getMessage());
		}

		return str;
	}

	@Override
	public List<Bids> vendorBidHistory(int vendorId) throws BidsException {
		// TODO Auto-generated method stub
		List<Bids> bids = new ArrayList<>();

		try (Connection con = SqlConnect.provideConnection()) {

			PreparedStatement ps = con.prepareStatement("select * from bids where vendorId=?");
			ps.setInt(1, vendorId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bids.add(new Bids(rs.getInt("bidId"), rs.getInt("vendorId"), rs.getInt("tenderId"),
						rs.getInt("bidAmount"), rs.getString("submission_details"), rs.getString("bidStatus")));

			}

			if (bids.size() == 0) {
				throw new BidsException("No Tender  Bidded");
			}
		} catch (SQLException e) {
			throw new BidsException(e.getMessage());
		}

		return bids;
	}

}

package com.TMSDAO.VendorUseCases;

import java.util.Scanner;

import com.TMSDAO.AdminUseCases.Colors;
import com.TMSDAO.DAO.VendorIntr;
import com.TMSDAO.DAO.VendorIntrImpl;

public class BidaTender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		

		System.out.println(Colors.getPurple() +"Enter tender id: " + Colors.getReset());
		int tenderId = sc.nextInt();
		System.out.println(Colors.getPurple() +"Enter Vendor id: " + Colors.getReset());
		int vendorId = sc.nextInt();
		System.out.println(Colors.getPurple() +"Enter bid  Amount: " + Colors.getReset());
		int bidAmount  = sc.nextInt();
		
		System.out.println(Colors.getPurple() +"Enter bid submission_details: " + Colors.getReset());
		String submission_details = sc.next();

		try {

			VendorIntr vendor = new VendorIntrImpl();

			String str = vendor.bidAgainstaTender(tenderId,vendorId,bidAmount,submission_details);
			System.out.println(Colors.getPurple()
                    + str+ Colors.getReset());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}

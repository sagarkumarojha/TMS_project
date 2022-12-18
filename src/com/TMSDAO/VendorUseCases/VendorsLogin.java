package com.TMSDAO.VendorUseCases;

import java.util.Scanner;

import com.TMSDAO.AdminUseCases.Colors;
import com.TMSDAO.DAO.VendorIntr;
import com.TMSDAO.DAO.VendorIntrImpl;
import com.TMSDAO.Models.Vendors;

public class VendorsLogin {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println(Colors.getBbgGreen() +"Enter Vendor PhoneNumber: "+ Colors.getReset() );
		String vendorUserName = sc.next();

		System.out.println(Colors.getBbgGreen() +"Enter Vendor Password: "+ Colors.getReset() );
		String vendorPassword = sc.next();

		try {

			VendorIntr vendor = new VendorIntrImpl();

			Vendors vendor1 = vendor.loginVendor(vendorUserName, vendorPassword);
			
			System.out.println(Colors.getBbgGreen()  +"=========== Welcome "+vendorUserName+" ==========="+ Colors.getReset() );
			
			System.out.println(vendor1);
			if (vendor1!=null) {
				
				while (true) {
					
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					
					System.out.println(Colors.getBbgGreen()  + "Press 1 to view all the Available Tenders.".toUpperCase() + Colors.getReset() );
					System.out.println(Colors.getBbgGreen()  +"Press 2 to Bid a Tender.".toUpperCase() + Colors.getReset() );
					System.out.println(Colors.getBbgGreen()  +"Press 3 to view current status of a Bid".toUpperCase() + Colors.getReset() );
					System.out.println(Colors.getBbgGreen()  +"Press 4 to view own Bid History." + Colors.getReset() );
					System.out.println(Colors.getBbgGreen()  +"Enter 5 to Logout" + Colors.getReset() );
					
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					
					int num = sc.nextInt();

					switch (num) {

					case 1:
						GetAvailableTenders.main(args);
						break;
					case 2:
						BidaTender.main(args);
						break;
					case 3:
						StatusOfMyBid.main(args);
						break;
					case 4:
						VendorBidHistory.main(args);
						break;
					case 5: {
						System.out.println("Vendor "+vendorUserName+" Logout Succesfull....");
						return;
					}
					default:
						System.out.println("Select valid option");

					}

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
}
}

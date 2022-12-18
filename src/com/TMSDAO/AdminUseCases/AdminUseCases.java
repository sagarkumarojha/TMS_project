package com.TMSDAO.AdminUseCases;

import java.util.Scanner;

import com.TMSDAO.DAO.AdminIntr;
import com.TMSDAO.DAO.AdminIntrImpl;

public class AdminUseCases {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Colors.getBbgYellow() +"Enter Admin Username: " + Colors.getReset());
		String adminUserName = sc.next();
		
		System.out.println(Colors.getBbgYellow()+"Enter Addmin Password: " + Colors.getReset());
		String adminPassword = sc.next();
		
		try {
			
			AdminIntr admin = new AdminIntrImpl();
			
			Boolean adminIsPresent = admin.adminLogin(adminUserName, adminPassword);
			
			if(adminIsPresent) {
				System.out.println("============================================");
				System.out.println("Login Successful");
				System.out.println("============================================");
				
				while(true) {
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					System.out.println(Colors.getBgWhite() +"Enter 1 to register a vendor"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 2 to view all vendors"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 3 to Create new tenders."+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 4 to view all tendors"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 5 to view all bids"+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 6 to View All the Bids of a tender."+Colors.getReset());
					System.out.println(Colors.getBgWhite() +"Enter 7 to Assign tender to a vendor"+Colors.getReset());
					
					System.out.println(Colors.getBgWhite() +"Enter 8 to Logout"+Colors.getReset());
					System.out.println();
					System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
					System.out.println();
					
					int num = sc.nextInt();
					
					
					
				
                   switch(num) {
					
					case 1 : RegisterVendor.main(args);
							  break;
					case 2 : GetAllVendor.main(args);
					  		  break;
					case 3 : AddNewTender.main(args);
							  break;
					case 4 : GetAllTender.main(args);
							  break;
					case 5 : GetAllBids.main(args);
					  		  break;
					case 6 : GetAllBidsOfATender.main(args);
							  break;
					case 7 : AssignTendor.main(args);
							  break;
					case 8 : {
						System.out.println("============================================");
						System.out.println("LogOut Successful");
						System.out.println("============================================");
								return;
							 }
					default : System.out.println("Select valid option");
					
					}
					
				}
			}
			} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}

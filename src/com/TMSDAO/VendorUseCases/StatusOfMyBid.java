package com.TMSDAO.VendorUseCases;

import java.util.Scanner;

import com.TMSDAO.AdminUseCases.Colors;
import com.TMSDAO.DAO.VendorIntr;
import com.TMSDAO.DAO.VendorIntrImpl;

public class StatusOfMyBid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println(Colors.getBbgGreen() +"Enter your Bid id: "+ Colors.getReset());
		int bid = sc.nextInt();
		
		VendorIntr vendor = new VendorIntrImpl();
		
		try {
			
			String str =  vendor.statusOfBid(bid);
			System.out.println(Colors.getBbgGreen()
                    +str + Colors.getReset());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}

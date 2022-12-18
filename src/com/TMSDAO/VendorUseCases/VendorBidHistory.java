package com.TMSDAO.VendorUseCases;

import java.util.List;
import java.util.Scanner;

import com.TMSDAO.AdminUseCases.Colors;
import com.TMSDAO.DAO.VendorIntr;
import com.TMSDAO.DAO.VendorIntrImpl;
import com.TMSDAO.Models.Bids;

public class VendorBidHistory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
		
		System.out.println(Colors.getBbgYellow() +"Enter your vendor id: "+ Colors.getReset());
		int vid = sc.nextInt();
		
		VendorIntr vendor = new VendorIntrImpl();
		
		try {
			
			List<Bids> bids =  vendor.vendorBidHistory(vid);
			
			bids.forEach(b -> System.out.println(Colors.getBbgYellow() 
                    +b + Colors.getReset()));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}

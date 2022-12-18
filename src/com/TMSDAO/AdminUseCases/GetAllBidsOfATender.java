package com.TMSDAO.AdminUseCases;

import java.util.List;
import java.util.Scanner;

import com.TMSDAO.DAO.AdminIntr;
import com.TMSDAO.DAO.AdminIntrImpl;
import com.TMSDAO.Models.Bids;

public class GetAllBidsOfATender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(Colors.getYellow() +"Enter your tenderId: "+ Colors.getReset());
		int tenderId  = sc.nextInt();
		
		AdminIntr admin = new AdminIntrImpl();
		
		try {
			
			List<Bids> bids =  admin.getAllBidsOfTender(tenderId);
			System.out.println(bids);
			bids.forEach(b -> System.out.println(Colors.getYellow()
                    +b+ Colors.getReset()));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


}

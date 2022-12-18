package com.TMSDAO.AdminUseCases;

import java.util.Scanner;

import com.TMSDAO.DAO.AdminIntr;
import com.TMSDAO.DAO.AdminIntrImpl;

public class AssignTendor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
		
        AdminIntr admin = new AdminIntrImpl();
		
		System.out.println(Colors.getPurple() +"Enter tendor id : " + Colors.getReset());
		int tid = sc.nextInt();
		
		System.out.println(Colors.getPurple() +"Enter vendor id : " + Colors.getReset());
		int vid = sc.nextInt();
		
		System.out.println(Colors.getPurple() +"Enter bid id : " + Colors.getReset());
		int bid = sc.nextInt();
		
		try {
			String str =  admin.assignTendor(tid, vid,bid);
			System.out.println(Colors.getPurple()
                    + str+ Colors.getReset());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		


	}

}

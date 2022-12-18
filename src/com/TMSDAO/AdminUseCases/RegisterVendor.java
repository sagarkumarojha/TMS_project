package com.TMSDAO.AdminUseCases;

import java.util.Scanner;

import com.TMSDAO.DAO.AdminIntr;
import com.TMSDAO.DAO.AdminIntrImpl;
import com.TMSDAO.Models.Vendors;

public class RegisterVendor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminIntr admin = new AdminIntrImpl();
		Scanner sc = new Scanner(System.in);
		
		
	
		
		System.out.println(Colors.getBbgYellow() +"Enter vendor firstname : "+ Colors.getReset());
		String name = sc.next();
		
		System.out.println(Colors.getBbgYellow() +"Enter vendor Mobile no. : "+ Colors.getReset());
		String mob = sc.next();
		
		System.out.println(Colors.getBbgYellow() +"Enter vendor Email-Id : "+ Colors.getReset());
		
		String email = sc.next();
		
		System.out.println(Colors.getBbgYellow() +"Enter vendor password : "+ Colors.getReset());
		String pass = sc.next();
		
		try {
			Vendors v= new Vendors();
			v.setVendorname(name);
			v.setVendorEmail(email);
			v.setVendorPhone(mob);
			v.setVendorPassword(pass);
			
			
			String str = admin.registerVender(v);
			System.out.println(Colors.getBbgYellow()
                    +str + Colors.getReset());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
}

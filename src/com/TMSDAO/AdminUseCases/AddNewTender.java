package com.TMSDAO.AdminUseCases;

import java.util.Scanner;

import com.TMSDAO.DAO.AdminIntr;
import com.TMSDAO.DAO.AdminIntrImpl;
import com.TMSDAO.Models.Tenders;

public class AddNewTender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		AdminIntr admin = new AdminIntrImpl();

		System.out.println(Colors.getBbgBlue() + "Enter tender Title: " + Colors.getReset());
		String Title = sc.nextLine();
	
		System.out.println(Colors.getBbgBlue() + "Enter tender Description: " + Colors.getReset());
		String Description = sc.nextLine();
		
		System.out.println(Colors.getBbgBlue() + "Enter tender Price: " + Colors.getReset());
		int Price = sc.nextInt();

		try {
			Tenders t=new Tenders();
			t.setTenderTitle(Title);
			t.setTenderPrice(Price);
			t.setTenderStatus("open");
			t.setTenderdescription(Description);
			String str = admin.addNewTender(t);
			System.out.println(Colors.getRed()
                    + str+ Colors.getReset());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

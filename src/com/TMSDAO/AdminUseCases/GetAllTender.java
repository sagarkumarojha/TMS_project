package com.TMSDAO.AdminUseCases;



import java.util.List;

import com.TMSDAO.DAO.AdminIntr;
import com.TMSDAO.DAO.AdminIntrImpl;
import com.TMSDAO.Models.Tenders;

public class GetAllTender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminIntr admin = new AdminIntrImpl();
		
		try {
			
			List<Tenders> tendors =	admin.getAllTender();
			tendors.forEach( t -> System.out.println(Colors.getRed()
                    +t+ Colors.getReset()));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

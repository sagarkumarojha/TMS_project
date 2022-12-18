package com.TMSDAO.AdminUseCases;

import java.util.List;

import com.TMSDAO.DAO.AdminIntr;
import com.TMSDAO.DAO.AdminIntrImpl;
import com.TMSDAO.Models.Vendors;

public class GetAllVendor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminIntr admin = new AdminIntrImpl();
         try {
			
			List<Vendors> vendors =	admin.getAllVender();
			vendors.forEach( v -> System.out.println(Colors.getBgGreen()
                    +v + Colors.getReset()));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

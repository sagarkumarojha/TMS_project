package com.TMSDAO.VendorUseCases;

import java.util.List;

import com.TMSDAO.AdminUseCases.Colors;
import com.TMSDAO.DAO.VendorIntr;
import com.TMSDAO.DAO.VendorIntrImpl;
import com.TMSDAO.Models.Tenders;

public class GetAvailableTenders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VendorIntr vendor = new VendorIntrImpl();
		
		try {
			
			List<Tenders> tendors =	vendor.getAvailableTendersList();
			tendors.forEach( t -> System.out.println(Colors.getBbgGreen()
                    +t + Colors.getReset()));
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

package com.TMSDAO.AdminUseCases;

import java.util.List;

import com.TMSDAO.DAO.AdminIntr;
import com.TMSDAO.DAO.AdminIntrImpl;
import com.TMSDAO.Models.Bids;

public class GetAllBids {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 AdminIntr admin = new AdminIntrImpl();
        try {
			
			List<Bids> bids =  admin.getAllBids();
			bids.forEach(b -> System.out.println(Colors.getBgPurple()
                    +b+ Colors.getReset()));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

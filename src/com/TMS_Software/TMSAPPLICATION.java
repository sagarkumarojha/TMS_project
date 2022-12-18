package com.TMS_Software;

import java.util.Scanner;

import com.TMSDAO.AdminUseCases.AdminUseCases;
import com.TMSDAO.AdminUseCases.Colors;
import com.TMSDAO.VendorUseCases.VendorsLogin;

public class TMSAPPLICATION {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(Colors.getBbgGreen() + "*-*-*-*-*-*-*-*-*-*-*-*WELCOME TO  TMS SOFTWARE*-*-*-*-*-*-*-*-*-*-*-*-*"+ Colors.getReset());
		System.out.println();
		while (true) {
			
			System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
			System.out.println("*                                                           +");
			
			System.out.println("+	"+Colors.getBbgGreen()+"PRESS 1 FOR ADMINISTRATOR LOGIN"+ Colors.getBbgGreen()+"                     *");
			
			System.out.println("*	"+Colors.getBbgGreen()+"PRESS 2 FOR VENDOR LOGIN INTO APPLICATION"+ Colors.getBbgGreen()+"           +");

			System.out.println("+	"+Colors.getBbgGreen()+"PRESS 3 TO CLOSE THE APPLICATION"+ Colors.getBbgGreen()+"                    *");
			System.out.println("*                                                           +");
			System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
			System.out.println();
			
			int n = sc.nextInt();

			if (n == 1) {

				AdminUseCases.main(args);

			} else if (n == 2) {
				VendorsLogin.main(args);
			} else {
				System.out.println("Application closed successfully...");
				return;
			}
			

	}

}
}

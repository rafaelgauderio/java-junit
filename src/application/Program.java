package application;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Account cc1 = new Account();
		System.out.println(cc1.getId());
		System.out.println(cc1.getBalance());
		cc1.deposit(200.0);
		cc1.setId(1L);
		System.out.println(cc1);
		
		Account cc2 = new Account(2L, 1220.0);
		cc2.deposit(700.0);
		System.out.println(cc2);
		cc2.withdraw(250.0);
		System.out.println(cc2);
		cc2.fullWithdraw();
		System.out.println("Imprimindo cc2 após zerar o saldo.");
		System.out.println(cc2);
		
		
		

	}

}

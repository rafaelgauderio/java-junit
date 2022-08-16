package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	//m�todo de teste tem que ser void
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount () {
		//Arrange = preparando os dados, inst�ncia os objetos necess�rios
		double amount = 1000.0;
		/*0.015 * 1000 = 15 */
		double expectedValue = 985.00;
		Account conta = AccountFactory.createEmptyAccount();
		
		//acc: executa as opera��es necess�rias
		conta.deposit(amount);
		
		//Assert: o que deveria acontecer, ou seja, resultado esperado.
		//comparar valor esperado com o valor atual
		Assertions.assertEquals(expectedValue, conta.getBalance());	
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount () {
		double amount =-500.50;
		double expectedValue = 1000;
		Account conta = AccountFactory.createAccount(expectedValue);	
		conta.deposit(amount);
		Assertions.assertEquals(expectedValue, conta.getBalance());
		
		
	}
	
	@Test
	public void fullWithDrawShouldClearBalanceAndReturnFullBalance() {
		double expectedValue = 0.0;
		double balance = 500.0;
		Account conta = AccountFactory.createAccount(balance);		
		
		//fun��o zerar todo o saldo
		double result = conta.fullWithdraw();		
		
		Assertions.assertEquals(expectedValue,conta.getBalance());
		Assertions.assertTrue(expectedValue == conta.getBalance());
		Assertions.assertEquals(result, balance);
		Assertions.assertTrue(result == balance);		
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenThereIsSufficienteBalance() {
		
		Account acc = AccountFactory.createAccount(1000.0);
		acc.withdraw(800.0);
		//sacou 800 de um conta com saldo 1000, tem que sobre 200
		
		Assertions.assertEquals(200,acc.getBalance());
	}
	
	//para testar exce��o tem que capturar a classe do tipo da exce��o e usar uma
	//express�o lambda no argumento do execut�vel
	
	@Test
	public void withdrawShouldThrowExceptionWhenThereIsInsufficienteBalance() {
		//se tentar sacar um valor maior que o saldo deve lan�ar a exce��o.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account conta = AccountFactory.createAccount(900.0);
			conta.withdraw(900.50);
			
		});
	}
	
	
	@Test
	public void interestShouldEarnedWhenReceiveInterest () {
		
		double expectedValue = 1500 + 1500 * 0.01;
		double initialBalance = 1500;
		Account conta = AccountFactory.createAccount(initialBalance);	
		conta.interestEarned();
		Assertions.assertEquals(expectedValue, conta.getBalance());		
	}
	

}

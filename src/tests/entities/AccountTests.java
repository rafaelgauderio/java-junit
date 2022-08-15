package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {
	
	//método de teste tem que ser void
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount () {
		//Arrange = preparando os dados, instância os objetos necessários
		double amount = 1000.0;
		/*0.015 * 1000 = 15 */
		double expectedValue = 985.00;
		Account conta = new Account(1L,0.0);
		
		//acc: executa as operações necessárias
		conta.deposit(amount);
		
		//Assert: o que deveria acontecer, ou seja, resultado esperado.
		//comparar valor esperado com o valor atual
		Assertions.assertEquals(expectedValue, conta.getBalance());	
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount () {
		double amount =-500.50;
		double expectedValue = 1000;
		Account conta = new Account(1L,expectedValue);		
		conta.deposit(amount);
		Assertions.assertEquals(expectedValue, conta.getBalance());
		
		
	}
	

}

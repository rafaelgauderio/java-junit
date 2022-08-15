package entities;

public class Account {

	// taxa bancária por deposito
	public static double DEPOSITE_FEE_PERCENTAGE = 0.015;

	private Long id;
	private Double balance;

	public Account() {

	}

	public Account(Long id, Double balance) {
		this.id = id;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	/*
	 * cliente não pode alterar o saldo da conta livremente. Alterar apenas por
	 * saque ou depósito public void setBalance(Double balance) { this.balance =
	 * balance; }
	 * 
	 */

	public void deposit(double amount) {
		if (amount > 0) {
			amount = amount - amount * DEPOSITE_FEE_PERCENTAGE;
			balance += amount;
		}

	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
		} else if (amount > balance) {
			throw new IllegalArgumentException();
		}

	}
	
	//método para sacar tudo
	public double fullWithdraw() {
		double auxilliary = balance;
		balance = 0.0;
		return auxilliary;
	}

}

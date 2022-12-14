package entities;

public class Account {

	// taxa banc?ria por deposito
	public static double DEPOSITE_FEE_PERCENTAGE = 0.015;
	public static double INTEREST = 0.01;

	private Long id;
	private Double balance=0.0;

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
	 * cliente n?o pode alterar o saldo da conta livremente. Alterar apenas por
	 * saque ou dep?sito public void setBalance(Double balance) { this.balance =
	 * balance; }
	 * 
	 */

	public void deposit(double amount) {
		if (amount > 0.0 ) {
			amount = amount - amount * DEPOSITE_FEE_PERCENTAGE;
			this.balance += amount;
		} 

	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
		} else if (amount > balance) {
			throw new IllegalArgumentException();
		}

	}
	
	//m?todo para sacar tudo
	public double fullWithdraw() {
		double auxilliary = balance;
		balance = 0.0;
		return auxilliary;
	}
	
	//m?todo para ganhar juros de investimento
	public void interestEarned() {
		this.balance  += this.balance * INTEREST;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}
	
	

}

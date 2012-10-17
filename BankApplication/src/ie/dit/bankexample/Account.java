package ie.dit.bankexample;

public class Account {
	private double  balance;
	private int 	id;

	public Account(int id, double openingBalance) {
		this.balance = openingBalance;
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}	
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", id=" + id + "]";
	}
}

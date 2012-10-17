package ie.dit.bankexample;

import java.util.HashMap;
import java.util.Map;

public abstract class BankFacility 
	implements Runnable
{
	protected Map<Integer, Account> 	accounts;

	public BankFacility() {
		accounts = new HashMap<Integer, Account>();
	}
	
	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}
	
	public void withdrawMoney(int accountNumber, double amount) {
		Account account = accounts.get(accountNumber);
		account.withdraw(amount);
	}
	
	public void run() {
		/** Force each thread onto the waiting queue 
		 *  Promotes the OS having to make some choice and 
		 *  context switches while waiting. 
		 **/
		try {
			Thread.sleep(500);
		}
		catch(Exception ex) 
		{ 		
			// don't care
		}
	}
}

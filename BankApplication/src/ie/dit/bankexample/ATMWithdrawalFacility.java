package ie.dit.bankexample;

public class ATMWithdrawalFacility extends BankFacility
{
	@Override
	public void run() {
		{
			super.run();
			
			Account davesAccount = accounts.get(1);
			// Processing Dave's ATM withdrawals from yesterday
				davesAccount.withdraw(10);
				davesAccount.withdraw(20);
				davesAccount.withdraw(30);
		}	
	}
}

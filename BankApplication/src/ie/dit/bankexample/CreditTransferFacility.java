package ie.dit.bankexample;

public class CreditTransferFacility extends BankFacility
{
	@Override
	public void run() {
		super.run();
		
		Account davesAccount = accounts.get(1);
		/**  Making sure Dave's wages get paid */
		synchronized(davesAccount) {
			davesAccount.deposit(1000);
			/** Making sure Jimmy stumps up for that bet. */
			davesAccount.deposit(100);
		}
	}
}

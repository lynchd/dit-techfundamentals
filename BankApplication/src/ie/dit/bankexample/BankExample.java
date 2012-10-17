package ie.dit.bankexample;
import java.util.HashMap;

public class BankExample 
{
	public static void main(String argsv[]) 
		throws Exception
	{
		/** Repeat this experiment multiple times to illustrate 
		 *  the race 
		 */
		for(int i = 0; i < 100; i++) {
			OpenFacilitiesAndExecuteDavesTransactions();
		}
	}
	
	public static void OpenFacilitiesAndExecuteDavesTransactions() 
		throws Exception 
	{
		/** Account details are common to all facilities */
		Account davesAccount 					= new Account(1, 100);
		HashMap<Integer, Account> banksAccounts =  new HashMap<Integer, Account>();
		banksAccounts.put(davesAccount.getId(), davesAccount);
		
		/** Facilities need to execute in parallel. 						 */
		/** In this case, Dave is withdrawing money while his wages get paid */
		BankFacility withdrawlFaclity 			= new ATMWithdrawalFacility();
		BankFacility creditTransferFacility 	= new CreditTransferFacility();
		
		withdrawlFaclity.setAccounts(banksAccounts);
		creditTransferFacility.setAccounts(banksAccounts);
		
		/** Prepare and start each thread */
		Thread atmFacility 	= new Thread(withdrawlFaclity);
		Thread ctFacility	= new Thread(creditTransferFacility);
		atmFacility.start();
		ctFacility.start();
		
		/** Wait for threads to finish executing */
		atmFacility.join();
		ctFacility.join();
		
		/** Opening Balance = + 100 */
		/** Wages 			= +1000 */
		/** Withdrawal 		= -  10 */
		/** Withdrawal 		= -  20 */
		/** Withdrawal 		= -  30 */
		/** Closing Balance = +1040 */
		System.out.println(davesAccount);
	}

}

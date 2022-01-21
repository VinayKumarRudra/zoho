//$Id$
package bank.bankimpl;

import java.util.Scanner;

import bank.Bank;
import bank.debit.DebitCard;

public interface DebitCardImplentation {

	public static void debitCardMethod(Bank bank) {
		//Bank bank = new DebitCard();
		
		while(true) {
			System.out.println("1.Account Generation\n2.check Account Exist\n3.Pin Generation\n4.Check Balance\n5.Withdraw amount\n6.Credit amount");
			
			System.out.println("Choose the Operation : ");
			
			Scanner operation  = new Scanner(System.in);
			int selectoperation = operation.nextInt();
			
			if(selectoperation == 7) {
				break;
			}
			
			switch (selectoperation) {
			case 1 : 
				System.out.println("Account Generation Processing");
				System.out.println("Enter username : ");
				Scanner sc = new Scanner(System.in);
				String username = sc.nextLine();
				bank.accountGenerate(username);
				System.out.println("\n\n");
				break;
			case 2 :
				System.out.println("Checking.. ");
				System.out.println("1.via account name\n2.via account number");
				
				System.out.println("Choose the Choice: ");
				Scanner choice  = new Scanner(System.in);
				int select = choice.nextInt();
				Boolean checkaccount = null;
				switch(select) {
				case 1 :
					String accountname;
					sc = new Scanner(System.in);
					System.out.println("Enter account name : ");
					accountname = sc.nextLine();
					checkaccount = bank.checkAccount(accountname);
					break;
				case 2 :
					int accountnumber;
					System.out.println("Enter account number : ");
					sc = new Scanner(System.in);
					accountnumber = sc.nextInt();
					checkaccount = bank.checkAccount(accountnumber);
					break;
				default :
					break;
				}
				if(checkaccount) {
					System.out.println("Account exist");
				} else {
					System.out.println("Account not created yet");
				}
				System.out.println("\n\n");
				break;
			case 3 :
				System.out.println("Generating pin..");
				int accountnumber;
				sc = new Scanner(System.in);
				System.out.println("Enter account number : ");
				accountnumber = sc.nextInt();
				bank.pinGenerate(accountnumber);
				System.out.println("\n\n");
				break;
			case 4 :
				System.out.println("Checking Balance..");
				sc = new Scanner(System.in);
				System.out.println("Enter Pin numner : ");
				int pinnumber = sc.nextInt();
				float availablebalance = bank.checkBalance(pinnumber);
				System.out.println("Available Amount : "+availablebalance);
				System.out.println("\n\n");
				break;
			case 5 :
				System.out.println("Processing");
				sc = new Scanner(System.in);
				System.out.println("Enter pin number : ");
				accountnumber = sc.nextInt();
				bank.withdrawMoney(accountnumber);
				System.out.println("\n\n");
				break;
			case 6 :
				System.out.println("Processing");
				sc = new Scanner(System.in);
				System.out.println("Enter account number : ");
				accountnumber = sc.nextInt();
				bank.creditMoney(accountnumber);
				System.out.println("\n\n");
				break;
			default :
				break;
			}
		}

	}

}

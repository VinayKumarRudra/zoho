//$Id$
package bank.bankimpl;

import java.util.Scanner;
import bank.Bank;
import bank.credit.CreditCard;
import bank.debit.DebitCard;

public class BankImplemetation implements CreditBankImplementation{

	public static void main(String[] args) {
		System.out.println("Welcome to our bank\n"); 
		while(true) {
			System.out.println("1.debit card 2. credit card\n");
			System.out.println("Enter your choice : ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch(choice) {
			case 1 :
				Bank debitcard = new DebitCard();
				DebitCardImplentation.debitCardMethod(debitcard);
				break;
			case 2 :
				Bank creditcard = new CreditCard();
				CreditBankImplementation.creditCardMethod(creditcard);
				break;
			default :
				break;
			}
		}
	}

}

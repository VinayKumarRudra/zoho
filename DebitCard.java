//$Id$
package bank.debit;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import bank.Bank;

public class DebitCard implements Bank{

	private String name;
	private int cardnumber;
	private int cardpin;
	private int balance;
	public static Map<String,Integer> cardnumbermap = new HashMap<String,Integer>();
	public static Map<Integer,Integer> pinnumbermap = new HashMap<Integer,Integer>();
	public static Map<Integer,Float> balancemap = new HashMap<Integer,Float>();
	
	public int getAccountNumber(String username) {
		for(Map.Entry<String,Integer> map : cardnumbermap.entrySet()) {
			if(map.getKey().equals(username)) {
				return map.getValue();
			}
		}
		return 0;
	}
	
	@Override
	public void generateCardNumber(String name) {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
		cardnumbermap.put(name, number);
		int accountnumber = getAccountNumber(name);
		System.out.println("Thanks for creating account.\n This is your account number :"+accountnumber);
		balancemap.put(number,(float) 100);
	}

	
	@Override
	public void pinGenerate(int cardnumber) {
		for(int number : cardnumbermap.values()) {
			if(number == cardnumber) {
				System.out.println("Please Enter 4 digit number : ");
				Scanner pin = new Scanner(System.in);
				cardpin = pin.nextInt();
				pinnumbermap.put(cardnumber, cardpin);
				break;
			}
		}
	}

	@Override
	public void accountGenerate(String name) {
		int temp = 0;
		for(Map.Entry<String,Integer> map : cardnumbermap.entrySet()) {
			System.out.println("Hello");
			if(map.getKey().equals(name)) {
				System.out.println(map.getKey());
				temp = 1;
				break;
			}
		}
			if(temp == 1) {
				System.out.println("Account already created");
			}else {
				this.name = name;
				System.out.println("Account Generated");
				generateCardNumber(name);
			}
	}

	
	@Override
	public void withdrawMoney(int pinnumber) {
		for(Map.Entry<Integer,Integer> map : pinnumbermap.entrySet()) {
			if(map.getValue() == pinnumber) {
				System.out.println("Enter amount to be withdraw : ");
				
				Scanner creditamount = new Scanner(System.in);
				float amount = creditamount.nextInt();
				
				int accountnumber = map.getKey();
				for(Map.Entry<Integer,Float> mapping : balancemap.entrySet()) {
					if(mapping.getKey() == accountnumber) {
						if(amount>mapping.getValue()) {
							System.out.println("Insufficient Fund");
						} else {
							float newamount = 0;
							
							System.out.println("Amount "+amount+" debicted from your account");
							newamount = mapping.getValue()-amount;
							balancemap.replace(mapping.getKey(),newamount);
						}
					}
				}
			}
		}
	}

	@Override
	public void creditMoney(int accountnumber) {
		for(Map.Entry map : balancemap.entrySet()) {
			if((int)map.getKey() == accountnumber) {
				System.out.println("Enter amount to be credited : ");
				Scanner creditamount = new Scanner(System.in);
				float amount = creditamount.nextFloat(); 
				float newamount = (float)map.getValue()+amount;
				balancemap.replace(accountnumber,newamount);
			} else {
				
			}
		}
	}

	@Override
	public float checkBalance(int pinnumber) {
		for(Map.Entry<Integer,Integer> map : pinnumbermap.entrySet()) {
			System.out.println(map.getValue()+" "+pinnumber);
			if(map.getValue() == pinnumber) {
				int accountnumber = map.getKey();
				System.out.println("accountnumber : "+accountnumber);
				for(Map.Entry<Integer,Float> mapping : balancemap.entrySet()) {
					System.out.println(mapping.getKey()+" "+accountnumber);
					if(mapping.getKey() == accountnumber) {
						System.out.println(mapping.getValue());
						return mapping.getValue();
					}
				}
				
			}
		}
		return (float) 0;
	}


	@Override
	public Boolean checkAccount(int accountnumber) {
		for(int number : cardnumbermap.values()) {
			if(number == accountnumber) {
				return true;
			} else {
				return false;
			}
		}
		return null;
		
	}


	@Override
	public Boolean checkAccount(String username) {
		for(String name : cardnumbermap.keySet()) {
			if(name.equals(username)) {
				return true;
			} else {
				return false;
			}
		}
		return null;		
	}

}

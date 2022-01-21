//$Id$
package bank;

public interface Bank {
	public void generateCardNumber(String name);
	public void pinGenerate(int cardnumber);
	public void accountGenerate(String name);
	public Boolean checkAccount(int accountnumber);
	public Boolean checkAccount(String name);
	public void withdrawMoney(int accountnumber);
	public void creditMoney(int accountnumber);
	public float checkBalance(int accountnumber);
	
}

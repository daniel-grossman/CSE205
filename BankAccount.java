
public abstract class BankAccount {
	
	protected String accountID = "0000-0000-0000-0000";
	protected double interestRate = 0.0;
	protected int currentBalance = 0;
	
	public boolean credit(int pennies) {
		this.currentBalance += pennies;
		return true;
	}
	
	public abstract boolean debit(int pennies);
	
	public int getBalance() {
		return this.currentBalance;
	}
	
	public String getAccountID() {
		return this.accountID;
	}
	
	public void setAccountID(String id) {
		this.accountID = id;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double rate) {
		this.interestRate = rate;
	}
	
	public abstract void applyInterest();
	
	public abstract String accountInfo();
	
	

}

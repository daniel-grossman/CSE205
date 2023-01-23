import java.text.DecimalFormat;

public class CreditcardAccount extends BankAccount {
	private int limit = 0;
	
	public boolean debit(int pennies) {
		int total = this.currentBalance + pennies;
		if(limit >= total) {
			this.currentBalance -= pennies;
			return true;
		}
		else return false;
	}
	
	public int getLimit() {
		return this.limit;
	}
	
	public void setLimit(int newlimit) {
		this.limit = newlimit;
	}
	
	public void applyInterest() {
		double interest;
		if(this.currentBalance < 0) {
			interest = this.interestRate * this.currentBalance;
			this.currentBalance += interest;
		}
	}
	
	public String accountInfo() {
		DecimalFormat fmt = new DecimalFormat("$0.00");
		DecimalFormat fmt2 = new DecimalFormat("0.00%");
		return "Type of Account : Savings\nAccount ID      : " + this.accountID + "\nCurrent Balance : " + fmt.format(this.currentBalance/100.00) + "\nInterest rate   : " + fmt2.format(this.interestRate) + "\nCredit Limit    : " + fmt.format(this.limit/100); 
	}

}

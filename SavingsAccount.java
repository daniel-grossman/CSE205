import java.text.DecimalFormat;

public class SavingsAccount extends BankAccount {
	
	public boolean debit(int pennies) {
		if(pennies <= this.currentBalance) {
			this.currentBalance -= pennies;
			return true;
		}
		else return false;
	}
	
	public void applyInterest() {
		double interest;
		if(this.currentBalance > 0) {
			interest = this.interestRate * this.currentBalance;
			this.currentBalance += interest;
		}
	}
	
	public String accountInfo() {
		DecimalFormat fmt = new DecimalFormat("$0.00");
		DecimalFormat fmt2 = new DecimalFormat("0.00%");
		return "Type of Account : Savings\nAccount ID      : " + this.accountID + "\nCurrent Balance : " + fmt.format(this.currentBalance/100.00) + "\nInterest rate   : " + fmt2.format(this.interestRate); 
	}
}

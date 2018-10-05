public class BankAccount {
	private double balance;
	private int accountID;
	private String password;
	public BankAccount(double startBalance, int startID, String startPass) {
		balance = startBalance;
		accountID = startID;
		password = startPass;
	}
	public double getBalance() {
		return balance;
	}
	public int getID() {
		return accountID;
	}
	public void setPassword(String newPass) {
		password = newPass;
	}
	public String toString() {
		return accountID + "\t" + balance;
	}
	public boolean deposit(double deposit) {
		if (deposit < 0) return false;		
		balance+= deposit;
		return true;
	}
	public boolean withdraw(double withdrawal) {
		if (withdrawal > balance) return false;		
		balance -= withdrawal;
		return true;
	}
	private boolean authenticate(String password) {
		return this.password.equals(password);
	}
	public boolean transferTo(BankAccount other, double amount, String passsword) {
		return (this.authenticate(password) && this.withdraw(amount) && other.deposit(amount));
	}
}

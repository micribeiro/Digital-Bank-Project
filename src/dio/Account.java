package dio;

public class Account {
	
	private static final int STD_AGENCY = 4260;
	private static int SEQUENCY = 1;
	
	protected Customer customer;
	protected int agency;
	protected int accNumber;
	protected double balance;
	protected AccType type;
	
	public Account(Customer customer) {
		this.agency = Account.STD_AGENCY;
		this.accNumber = SEQUENCY++;
		this.customer = customer;	
	}
	
	public int getAgency() {
		return agency;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
		public AccType getType() {
		return type;
	}

	public void setType(AccType type) {
		this.type = type;
	}

	public void transfer(double amount, Account receiverAcc){
		this.withdraw(amount);
		receiverAcc.deposit(amount);
	}
	
	protected void printBasicInfo () {
		System.out.println(String.format("%s", this.customer.getName()));
		System.out.println(String.format("%s %s", Bank.BANK_CODE, Bank.BANK_NAME));
		System.out.println(String.format("Agency: %d", this.agency));
		System.out.println(String.format("Account Number: %d", this.accNumber));
		System.out.println(String.format("Balance: %.2f", this.balance));
	}
	
	public void printExtract() {
		System.out.println("\n=== Account Extraxt ===");
		this.printBasicInfo();
	}
}

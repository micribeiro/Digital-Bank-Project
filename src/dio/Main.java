package dio;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Customer cust = new Customer();
		cust.setName("Fabiana Marques");
		
		Account acc = new Account(cust);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello! BANK RIVER is a new bank in Brazil.");
		System.out.println("I hope you enjoy our services.");
		
		System.out.println("Please, enter your first name:");
		String firstName = scan.next();
		
		System.out.println("Please, enter your last name:");
		String lastName = scan.next();
		
		Customer customer = new Customer();
		customer.setName(firstName + " " + lastName);
		
		System.out.println("Which account type do you want to have?");
		System.out.println("1. Checking\n2. Savings");
		int accType = scan.nextInt();
		Account account = new Account(customer);
		
		switch(accType) {
		case 1:
			System.out.println("Checking account created.");
			account.setType(AccType.CHECKING);
			break;
		case 2:
			System.out.println("Savings account created.");
			account.setType(AccType.SAVINGS);
			break;
		}
		
		System.out.println("OK, " + firstName + ". How may we help you?");
		int action = 0;
		while(action != 5) {
		System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Extract\n5.Quit");
		action = scan.nextInt();
		
			switch (action){
			case 1:
				System.out.println("How much do you want to deposit?");
				double amountD = scan.nextDouble();
				account.deposit(amountD);
				System.out.println("Amount depositted. Balance: " + account.getBalance());
				break;
			case 2:
				System.out.println("How much do you want to withdraw?");
				double amountW = scan.nextDouble();
				if(amountW < account.balance) {
					account.withdraw(amountW);
					System.out.println("Amount withdrawn. Balance: " + account.getBalance());					
				} else {
					System.out.println("You do not have this amount of money.");
				}
				break;
			case 3:
				System.out.println("How much do you want to transfer?");
				double amountT = scan.nextDouble();
				if (amountT < account.balance) {
					System.out.println("At this moment you can transfer this amount to only one person:"
							+ "Fabiana Ribeiro. OK? Please type OK or NOK");
					String ansT = scan.next();
					if(ansT.equalsIgnoreCase("OK")) {
						account.transfer(amountT, acc);
						System.out.println("Amount transfered. Balance: " + account.getBalance());
					} else if(ansT.equalsIgnoreCase("NOK")) {
						System.out.println("Transaction cancelled.");
					}
				} else {
					System.out.println("You do not have this amount of money.");
				}
				break;
			case 4:
				account.printExtract();
				break;
			case 5:
				System.out.println("It was a pleasure to help you.");
				break;
			}
		}
		System.out.println("BANK RIVER thanks you for the preference.");
		scan.close();
	}
	
}

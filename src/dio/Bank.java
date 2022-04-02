package dio;
import java.util.List;

public class Bank {
	
	protected static final String BANK_NAME = "BANK RIVER";
	protected static final String BANK_CODE = "5820";
	
	public static String getBankName() {
		return BANK_NAME;
	}
	public static String getBankCode() {
		return BANK_CODE;
	}

	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	

}

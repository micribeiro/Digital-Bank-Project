package dio;

public enum AccType {
	SAVINGS("Savings Account"), CHECKING("Checking Account");
	
	protected String description;
	
	AccType(String description){
		this.description = description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}

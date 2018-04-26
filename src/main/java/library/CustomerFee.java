package library;

public enum CustomerFee {
	STUDENT(2.2), PENSIONER(2.2), REGULAR(2.5);

	private final double dailyFee;

	private CustomerFee(double dailyFee) {
		this.dailyFee = dailyFee;
	}

	public double getDailyFee() {
		return dailyFee;
	}

}

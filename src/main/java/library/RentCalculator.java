package library;

public class RentCalculator {

	public RentCalculator() {
	}

	public double calculateDailyFee(CustomerFee customer, Book... books) {
		double fee = 0;
		for (Book book : books) {
			fee += customer.getDailyFee();
		}
		return fee;
	}
}

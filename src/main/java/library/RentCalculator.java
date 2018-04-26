package library;

public class RentCalculator {

	public RentCalculator() {
	}

	public double calculateDailyFee(CustomerFee customer, Book... books) {
		double dailyFee = customer.getDailyFee();
		int countOfBooks = books.length;
		return countOfBooks * dailyFee;
	}
}

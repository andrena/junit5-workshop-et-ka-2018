package library;

import static java.lang.String.format;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Customer {
	private String name;
	private Map<Book, LocalDate> borrowedBooks;
	private CustomerFee customerFee;
	private RentCalculator rentCalculator;

	public Customer(String name, CustomerFee customerFee) {
		this.name = name;
		this.customerFee = customerFee;
		this.borrowedBooks = new HashMap<>();
		this.rentCalculator = new RentCalculator();
	}

	public void borrow(Book book, LocalDate borrowDate) {
		borrowedBooks.put(book, borrowDate);
	}

	public void writeBorrowedBooksReportToFile(File reportFile) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(reportFile);
		for (Entry<Book, LocalDate> borrowedBook : borrowedBooks.entrySet()) {
			fileOutputStream
					.write(getBorrowedBookReportLine(borrowedBook.getKey(), borrowedBook.getValue()).getBytes());
		}

		fileOutputStream.flush();
		fileOutputStream.close();
	}

	private String getBorrowedBookReportLine(Book borrowedBook, LocalDate borrowDate) {
		double dailyFee = rentCalculator.calculateDailyFee(customerFee, borrowedBook);
		double actualFee = Period.between(borrowDate, LocalDate.now()).getDays() * dailyFee;
		return format("%s rented %s at %s currentFee %s", name, borrowedBook.getTitle(),
				borrowDate.format(DateTimeFormatter.ISO_DATE), actualFee);
	}
}

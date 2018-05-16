package library;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Book> borrowedBooks;
	private LocalDate dueDate;
	private CustomerFee fee;

	public Customer(String name, CustomerFee fee) {
		this.name = name;
		this.fee = fee;
		borrowedBooks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	private String getBorrowedBookReportLine() {
		return String.format("%s rented %s at %s", name, borrowedBooks, dueDate.format(DateTimeFormatter.ISO_DATE));
	}

	public void borrow(Book booktitle, LocalDate dueDate) {
		this.borrowedBooks.add(booktitle);
		this.dueDate = dueDate;
	}

	public void writeBorrowedBooksReportToFile(File reportFile) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(reportFile);

		fileOutputStream.write(getBorrowedBookReportLine().getBytes());

		fileOutputStream.flush();
		fileOutputStream.close();
	}

}

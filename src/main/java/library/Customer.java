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

	private String getBorrowedBookReportLine(Book borrowedBook) {
		return String.format("%s rented %s at %s", name, borrowedBook.getTitle(), dueDate.format(DateTimeFormatter.ISO_DATE));
	}

	public void borrow(Book book, LocalDate dueDate) {
		this.borrowedBooks.add(book);
		this.dueDate = dueDate;
	}

	public void writeBorrowedBooksReportToFile(File reportFile) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(reportFile);

		for (Book book : borrowedBooks) {
			fileOutputStream.write(getBorrowedBookReportLine(book).getBytes());
		}

		fileOutputStream.flush();
		fileOutputStream.close();
	}

}

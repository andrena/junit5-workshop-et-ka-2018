package temporaryFolder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {
	private String name;
	private String borrowedBook;
	private LocalDate dueDate;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private String getBorrowedBookReportLine() {
		return String.format("%s rented %s at %s", name, borrowedBook, dueDate.format(DateTimeFormatter.ISO_DATE));
	}

	public void borrow(String booktitle, LocalDate dueDate) {
		this.borrowedBook = booktitle;
		this.dueDate = dueDate;
	}

	public void writeBorrowedBooksReportToFile(File reportFile) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(reportFile);

		fileOutputStream.write(getBorrowedBookReportLine().getBytes());

		fileOutputStream.flush();
		fileOutputStream.close();
	}

}

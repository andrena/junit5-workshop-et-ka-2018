package temporaryFolder;

import library.Book;
import library.Customer;
import library.CustomerFee;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import static java.nio.file.Files.lines;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerJunit4Test {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void generateBorrowedBooksReport_generatesAReportFileWithTheBorrowedBook() throws IOException {
		Customer customer = new Customer("CustomerName", CustomerFee.REGULAR);
		customer.borrow(new Book("1", "BookTitle"), LocalDate.of(2018, Month.MAY, 4));

		File file = temporaryFolder.newFile("customerReportFile.txt");
		customer.writeBorrowedBooksReportToFile(file);

		lines(file.toPath()).forEach(line -> assertThat(line).isEqualTo("CustomerName rented BookTitle at 2018-05-04"));
	}

}

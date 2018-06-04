package temporaryFolder;

import static java.nio.file.Files.lines;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import library.Book;
import library.Customer;
import library.CustomerFee;

public class TemporaryFolderTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void generateBorrowedBooksReport_generatesAReportFileWithTheBorrowedBook() throws IOException {
		Customer customer = new Customer("CustomerName", CustomerFee.REGULAR);
		LocalDate yesterday = LocalDate.now().minusDays(1);
		customer.borrow(new Book("3-598-21506-1", "BookTitle"), yesterday);

		File file = temporaryFolder.newFile("customerReportFile.txt");
		customer.writeBorrowedBooksReportToFile(file);

		lines(file.toPath())
				.forEach(line -> assertThat(line)
						.isEqualTo("CustomerName rented BookTitle at " + yesterday.format(DateTimeFormatter.ISO_DATE)
								+ " currentFee " + CustomerFee.REGULAR.getDailyFee()));
	}

}

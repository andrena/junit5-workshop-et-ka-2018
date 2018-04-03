package temporaryFolder;

import static java.nio.file.Files.lines;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CustomerJunit4Test {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void generateBorrowedBooksReport_generatesAReportFileWithTheBorrowedBook() throws IOException {
		Customer customer = new Customer("CustomerName");
		customer.borrow("BookTitle", LocalDate.of(2018, Month.MAY, 4));

		File file = temporaryFolder.newFile("customerReportFile.txt");
		customer.writeBorrowedBooksReportToFile(file);

		lines(file.toPath()).forEach(line -> assertThat(line).isEqualTo("CustomerName rented BookTitle at 2018-05-04"));
	}

}

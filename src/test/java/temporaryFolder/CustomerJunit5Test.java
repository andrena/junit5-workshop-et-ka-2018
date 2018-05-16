package temporaryFolder;

import static java.nio.file.Files.lines;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import extensions.temporaryFolder.TempDirectory;
import extensions.temporaryFolder.TempDirectory.TempDir;
import library.Customer;
import library.CustomerFee;

public class CustomerJunit5Test {

	@Test
	@ExtendWith(TempDirectory.class)
	public void generateBorrowedBooksReport_generatesAReportFileWithTheBorrowedBook(@TempDir Path file)
			throws IOException {

		Customer customer = new Customer("CustomerName", CustomerFee.REGULAR);
		customer.borrow("BookTitle", LocalDate.of(2018, Month.MAY, 4));

		File reportFile = new File(file.toFile(), "report");
		customer.writeBorrowedBooksReportToFile(reportFile);

		lines(reportFile.toPath())
				.forEach(line -> assertThat(line).isEqualTo("CustomerName rented BookTitle at 2018-05-04"));
	}

}

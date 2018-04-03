package temporaryFolder;

import static java.nio.file.Files.lines;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import extensions.temporaryFolder.TempFile;
import extensions.temporaryFolder.TemporaryFolderExtension;

public class CustomerJunit5Test {

	@Test
	@ExtendWith(TemporaryFolderExtension.class)
	public void generateBorrowedBooksReport_generatesAReportFileWithTheBorrowedBook(@TempFile File file)
			throws IOException {
		Customer customer = new Customer("CustomerName");
		customer.borrow("BookTitle", LocalDate.of(2018, Month.MAY, 4));

		customer.writeBorrowedBooksReportToFile(file);

		lines(file.toPath()).forEach(line -> assertThat(line).isEqualTo("CustomerName rented BookTitle at 2018-05-04"));
	}

}

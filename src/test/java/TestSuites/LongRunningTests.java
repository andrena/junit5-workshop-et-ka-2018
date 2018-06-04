package TestSuites;

import library.RentCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import temporaryFolder.TemporaryFolderTest;

@RunWith(Suite.class)
@SuiteClasses({RentCalculatorTest.class, TemporaryFolderTest.class})
public class LongRunningTests {

}

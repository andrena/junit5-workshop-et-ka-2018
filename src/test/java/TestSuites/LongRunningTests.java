package TestSuites;

import library.RentCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import temporaryFolder.CustomerJunit4Test;

@RunWith(Suite.class)
@SuiteClasses({RentCalculatorTest.class, CustomerJunit4Test.class})
public class LongRunningTests {

}

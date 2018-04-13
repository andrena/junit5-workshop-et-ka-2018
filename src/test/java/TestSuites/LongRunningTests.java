package TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import library.RentCalculatorJunit4Test;
import temporaryFolder.CustomerJunit4Test;

@RunWith(Suite.class)
@SuiteClasses({ RentCalculatorJunit4Test.class, CustomerJunit4Test.class })
public class LongRunningTests {

}

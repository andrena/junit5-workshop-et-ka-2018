package TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import felix.Junit4ParamterizedTest;
import temporaryFolder.CustomerJunit4Test;

@RunWith(Suite.class)
@SuiteClasses({
  Junit4ParamterizedTest.class,
  CustomerJunit4Test.class
})


public class LongRunningTests {
	
}

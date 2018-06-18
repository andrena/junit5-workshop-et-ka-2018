package TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import temporaryFolder.TemporaryFolderTest;

@RunWith(Suite.class)
@SuiteClasses({TemporaryFolderTest.class})
public class TestSuiteOfLongRunningTests {

}

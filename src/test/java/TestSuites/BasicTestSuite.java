package TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import abstractTests.BookTest;
import abstractTests.FunReadingTest;
import abstractTests.SpeedReadingTest;
import annotationen.AnnotationTest;
import expectedException.ExceptionAnnotationTest;
import expectedException.ExceptionRuleTest;
import hamcrestAssertJ.HamcrestAssertJTest;
import library.RentCalculatorTest;
import temporaryFolder.TemporaryFolderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BookTest.class, FunReadingTest.class, SpeedReadingTest.class, AnnotationTest.class,
		ExceptionRuleTest.class, ExceptionAnnotationTest.class, HamcrestAssertJTest.class, RentCalculatorTest.class,
		TemporaryFolderTest.class })
public class BasicTestSuite {
}

package TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import abstractTests.BookTest;
import abstractTests.FunReadingTest;
import abstractTests.SpeedReadingTest;
import annotationen.AnnotationTest;
import expectedException.ExceptionRuleTest;
import expectedException.ExceptionAnnotationTest;
import hamcrestAssertJ.HamcrestAssertJTest;
import library.RentCalculatorTest;
import nested.HierarchicalLibraryTest;
import temporaryFolder.TemporaryFolderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BookTest.class, FunReadingTest.class, SpeedReadingTest.class, AnnotationTest.class,
		ExceptionRuleTest.class, ExceptionAnnotationTest.class, HamcrestAssertJTest.class, 
		RentCalculatorTest.class, HierarchicalLibraryTest.class, TemporaryFolderTest.class })
public class BasicTestSuite {
}

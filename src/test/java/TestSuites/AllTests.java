package TestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import HamcrestAssertJ.HamcrestAssertJTest;
import abstractTests.BookTest;
import abstractTests.FunReadingTest;
import abstractTests.SpeedReadingTest;
import annotationen.AnnotationTest;
import expectedException.ISBN10Test;
import expectedException.ISBNValidatorTest;
import library.RentCalculatorTest;
import nested.HierarchicalLibraryTest;
import temporaryFolder.TemporaryFolderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BookTest.class, FunReadingTest.class, SpeedReadingTest.class, AnnotationTest.class,
		ISBN10Test.class, ISBNValidatorTest.class, HamcrestAssertJTest.class, 
		RentCalculatorTest.class, HierarchicalLibraryTest.class, TemporaryFolderTest.class })
public class AllTests {
}

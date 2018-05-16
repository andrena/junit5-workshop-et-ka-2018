package TestSuites;

import HamcrestAssertJ.HamcrestAssertJTest;
import abstractTests.*;
import annotationen.AnnotationTest;
import annotationen.LifeCycleAnnotationTest;
import common.BookFactory;
import expectedException.ISBN10Test;
import expectedException.ISBNValidatorTest;
import library.DatabaseTest;
import library.RentCalculatorJunit4Test;
import nested.HierarchicalLibraryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import temporaryFolder.CustomerJunit4Test;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BookPropertiesTest.class,
        BookTest.class,
        FunReadingTest.class,
        ReadingMethodTest.class,
        SpeedReadingTest.class,
        AnnotationTest.class,
        LifeCycleAnnotationTest.class,
        BookFactory.class,
        ISBN10Test.class,
        ISBNValidatorTest.class,
        HamcrestAssertJTest.class,
        DatabaseTest.class,
        RentCalculatorJunit4Test.class,
        HierarchicalLibraryTest.class,
        CustomerJunit4Test.class
})
public class AllTests {
}

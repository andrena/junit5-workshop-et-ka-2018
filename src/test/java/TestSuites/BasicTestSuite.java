package TestSuites;

import abstractTests.FunAbstractTest;
import abstractTests.SpeedAbstractTest;
import annotationen.AnnotationTest;
import expectedException.ExceptionAnnotationTest;
import expectedException.ExceptionRuleTest;
import hamcrestAssertJ.HamcrestAssertJTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import temporaryFolder.TemporaryFolderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({FunAbstractTest.class, SpeedAbstractTest.class, AnnotationTest.class,
        ExceptionRuleTest.class, ExceptionAnnotationTest.class, HamcrestAssertJTest.class,
        TemporaryFolderTest.class})
public class BasicTestSuite {
}

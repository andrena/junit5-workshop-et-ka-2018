package TestSuites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import abstractTests.SpeedAbstractTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ SpeedAbstractTest.class })
@SelectPackages({ "expectedException", "customExtension", "mockenOhneMockitoRunner" })
public class BasicTestSuite {
}

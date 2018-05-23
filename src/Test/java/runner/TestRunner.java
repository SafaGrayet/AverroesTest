package runner;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



    @CucumberOptions(features = "src/test/java/features",
            format = {"pretty", "html:target/cucumber", "json:target/cucumber-  report.json"},
            monochrome = true,
            glue = {"steps"})

public class TestRunner extends AbstractTestNGCucumberTests {
        private TestNGCucumberRunner testNGCucumberRunner;
        @BeforeClass(alwaysRun = true)
        public void setUpClass() throws Exception {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }
        @Test(groups = "steps", description = "Runs Cucumber Feature", dataProvider = "features")
        public void feature(CucumberFeatureWrapper cucumberFeature) {
            testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        }
        @DataProvider
        public Object[][] features() {
            return testNGCucumberRunner.provideFeatures();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() throws Exception {
            testNGCucumberRunner.finish();
        }



}





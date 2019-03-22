package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static core.DriverFactory.killDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/",
        glue = "tests"
)
public class runner {

    @AfterClass
    public static void finishAll(){
        killDriver();
    }

}
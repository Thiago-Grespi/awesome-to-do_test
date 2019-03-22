package core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;
import static core.Propriedades.FECHAR_BOWSER;

public class baseTest {

    @Rule
    public TestName testName = new TestName();

    @After
    public void finish() throws IOException {
        screenCapture();
        if(FECHAR_BOWSER){
            killDriver();
        }
    }

    private void screenCapture() throws IOException {
        TakesScreenshot screenShot = (TakesScreenshot) getDriver();
        File screenImage = screenShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenImage, new File("target" + File.separator + "screenshot" + File.separator + testName + ".jpg"));
    }


}

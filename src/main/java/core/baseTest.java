package core;

import org.junit.After;

import static core.DriverFactory.killDriver;

public class baseTest {

    @After
    public void ends(){
        killDriver();
    }
}

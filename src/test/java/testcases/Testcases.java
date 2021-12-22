package testcases;

import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.drivers.web.RemoteWebDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class Testcases {
    DesiredCapabilities caps = null;
    WebDriver driver = null;
    String token = "abc";
    Login login = null;

    @BeforeSuite
    public void setup() throws InvalidTokenException, MalformedURLException, ObsoleteVersionException, AgentConnectException {

        caps = new DesiredCapabilities();
        caps.setCapability("browserName","chrome");

        driver = new RemoteWebDriver(token,caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        login = new Login(driver);
    }

    @Test
    public void clickA(){
        login.clickA();
    }

    public void  teardown(){
        driver.quit();

    }
}

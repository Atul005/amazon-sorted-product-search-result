package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.BrowserFactory;
import utilities.DataConfigProvider;

public class BasePage {

    public DataConfigProvider dataConfigProvider = new DataConfigProvider();
    public WebDriver webDriver;

    @BeforeClass
    public void setUp(){
        webDriver = BrowserFactory.startApplication(webDriver, dataConfigProvider.getBrowser(), dataConfigProvider.getURL());
    }

    @AfterClass
    public void quit(){
        webDriver.quit();
    }
}

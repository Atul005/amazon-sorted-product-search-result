package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {


    public static WebDriver startApplication(WebDriver webDriver, String browserName, String url){

        if(browserName.equals("CHROME")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }




        webDriver.manage().window().maximize();
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return webDriver;

    }


}

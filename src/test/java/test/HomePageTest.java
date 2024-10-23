package test;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage {


    @Test
    void searchItemTest(){
        HomePage homePage = new HomePage(webDriver);
        String item = "lg soundbar";
        homePage.searchItem(item);
    }

}

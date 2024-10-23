package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver webDriver;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id="twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(id="nav-search-submit-button")
    WebElement searchIcon;

    public void searchItem(String itemName){
        searchBar.sendKeys(itemName);
        searchIcon.click();
    }

}

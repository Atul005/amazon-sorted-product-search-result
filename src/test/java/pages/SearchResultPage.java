package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchResultPage {

    WebDriver webDriver;

    public SearchResultPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "a-dropdown-label")
    WebElement sortIcon;

    @FindBy(id = "s-result-sort-select_1")
    WebElement sortOption;

    public void sortResultLowToHigh(){
        sortIcon.click();
        sortOption.click();
    }

    public Map<String, Map<String, String>> fetchProducts(){
        Map<String, String> productPriceMap = new HashMap<>();
        Map<String, String> ignoredProduct = new HashMap<>();
        Map<String, String> exceptionMap = new HashMap<>();

        Map<String, Map<String, String>> returnMap = new HashMap<>();

        List<WebElement> productList;
        List<WebElement> productPriceList;
        try {
            productList = webDriver.findElements(By.xpath("//div[@data-component-type=\"s-search-result\"]//div[@data-cy=\"title-recipe\"]//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
            productPriceList = webDriver.findElements(By.xpath("//div[@data-component-type=\"s-search-result\"]//div[@data-cy=\"price-recipe\"]//span[@class=\"a-price-whole\"]"));

            for (int i = 0; i < productPriceList.size(); i++) {
                WebElement product = productList.get(i);
                WebElement price = productPriceList.get(i);
                try {
                    String text = product.getText();
                    String productName = sanitizeProductName(text);
                    String productPrice = price.getText();
                    System.out.println("[MAP] "+productName+" -> "+productPrice);
                    productPriceMap.put(productName, productPrice);
                } catch (Exception ex){
                    ignoredProduct.put(product.getText(), price.getText());
                    exceptionMap.put(product.getText(), ex.getMessage());
                }
            }

        }
            catch(Exception ignoredException){
                System.out.println("Product cannot be fetched, "+ignoredException);
            }
        returnMap.put("PRODUCT_MAP",productPriceMap);
        returnMap.put("IGNORED_PRODUCT_MAP",ignoredProduct);
        returnMap.put("EXCEPTION_MAP",exceptionMap);
        return returnMap;
    }

    private String fetchPriceFromText(String text){
        String[] arr = text.split("₹");
        return arr[1].replace("M.R.P:", "");
    }


    private String sanitizeProductName(String productName){
        if(productName.contains("Sponsored")){
            productName = productName.replaceAll("Sponsored\n", "");
        }
        productName = productName.split(",")[0];
        if(productName.length() > 40)
            productName = productName.substring(0, 40);
        return productName;
    }
}


package test;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SearchResultPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchResultTest extends BasePage {


    @Test
    public void aggregateSearchResultTest(){
        HomePage homePage = new HomePage(webDriver);
        homePage.searchItem("lg soundbar");
        SearchResultPage searchResultPage = new SearchResultPage(webDriver);
        //searchResultPage.sortResultLowToHigh();
        Map<String, Map<String, String>> fetchedProducts = searchResultPage.fetchProducts();

        Map<String, String> productPriceMap = fetchedProducts.get("PRODUCT_MAP");
        Map<String, String> ignoredProductMap = fetchedProducts.get("IGNORED_PRODUCT_MAP");
        Map<String, String> exceptionMap = fetchedProducts.get("EXCEPTION_MAP");

    }

}



package test;

import org.testng.annotations.Test;
import pages.BasePage;

public class BaseTest extends BasePage{

    @Test
    public void demoRun(){
        BasePage basePage = new BasePage();
    }
}

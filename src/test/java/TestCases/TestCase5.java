package TestCases;

import Pages.MainPage;
import Pages.SignInPage;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.Test;

public class TestCase5 extends BasicTest {
    @Page
    private MainPage mainPage;

    @Test(priority = 0)
    public void gotoSite() {
        caseInfo("1", "Go to www.amazon.ca");
        gotoURL();
        await().explicitlyFor(500);
    }

    @Test(priority = 1)
    public void searchFor() {
        caseInfo("2", "Search for memory card");

        String keyword = "memory card";

        mainPage.searchBar().searchFor(keyword);
        await().explicitlyFor(1000);

    }

    @Test(priority = 2)
    public void gotoItem()
    {
        caseInfo("3", "Go to target item");
        String itemName = "Sandisk Ultra 32GB Class 10 SDHC UHS-I Memory Card Up to 80MB, Grey/Black (SDSDUNC-032G-GN6IN)";
        mainPage.searchResults().gotoResult(itemName);
    }

    @Test(priority = 3)
    public void addToCart()
    {
        caseInfo("4", "Search for memory card");
        mainPage.item().addToCart();
        mainPage.item().proceedToCheckout();
        signInPage.signIn().fillInEmailAddr(username).fillInPassword(password);
        String currentUrl = getDriver().getCurrentUrl();
        if(currentUrl.contentEquals("https://www.amazon.ca/gp/buy/addressselect/handlers/display.html?hasWorkingJavascript=1"))
        {
            System.out.println("Navigated to address creation page");
        }
        else
        {
            throw new ArithmeticException("Current page is not address creation page");
        }
    }
}

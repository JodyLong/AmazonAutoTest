package TestCases;

import Pages.MainPage;
import Pages.SignInPage;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.Test;

public class TestCase4 extends BasicTest
{
    @Page
    private MainPage mainPage;

    @Test(priority = 0)
    public void gotoSite()
    {
        caseInfo("1", "Go to www.amazon.ca");
        gotoURL();
        await().explicitlyFor(500);
    }

    @Test(priority = 1)
    public void searchFor()
    {
        caseInfo("2", "Search for alpja");

        String keyword = "alpja";

        mainPage.searchBar().searchFor(keyword);
        await().explicitlyFor(1000);

        if(!mainPage.searchResults().checkErrorMsg())
        {
            throw new ArithmeticException("Expected message. No message displayed.");
        }
    }



}
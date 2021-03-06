package TestCases;

import Pages.MainPage;
import Pages.SignInPage;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.Test;

public class TestCase3 extends BasicTest
{
    @Page
    private MainPage mainPage;

    @Page
    private SignInPage signInPage;

    @Test(priority = 0)
    public void gotoSite()
    {
        //Test Case 3 - Step a
        caseInfo("1", "Go to www.amazon.ca");
        gotoURL();
        await().explicitlyFor(500);
    }

    @Test(priority = 1)
    public void searchFor()
    {
        caseInfo("2", "Search for memory card");

        String keyword = "memory card";
        //Test Case 3 - Step b
        mainPage.searchBar().searchFor(keyword);
        await().explicitlyFor(3000);

        //Test Case 3 - Step c
        mainPage.searchResults().checkResults();
    }

}

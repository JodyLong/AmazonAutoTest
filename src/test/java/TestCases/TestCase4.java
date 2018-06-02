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
        //Test Case 4 - Step a
        gotoURL();
        await().explicitlyFor(500);
    }

    @Test(priority = 1)
    public void searchFor()
    {
        caseInfo("2", "Search for alpja");

        String keyword = "alpja";
        //Test Case 4 - Step b
        mainPage.searchBar().searchFor(keyword);
        await().explicitlyFor(1000);

        //Test Case 4 - Step c
        //Note: when searching for "alpja" on amazon.ca, there are still searching results displayed, with a warning message:
        //      Showing results for alpha.Search instead for alpja.
        //This test case is for detecting that message
        if(!mainPage.searchResults().checkErrorMsg())
        {
            throw new ArithmeticException("Expected message. No message displayed.");
        }
    }



}
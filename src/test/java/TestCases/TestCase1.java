package TestCases;

import Pages.MainPage;
import Pages.SignInPage;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.Test;

public class TestCase1 extends BasicTest
{
    @Page
    private MainPage mainPage;

    @Page
    private SignInPage signInPage;


    @Test(priority = 0)
    public void gotoSite()
    {
        caseInfo("1", "Go to www.amazon.ca");
        //Test Case 1 - Step a&b
        gotoURL();
        await().explicitlyFor(500);

        if(!mainPage.navTools().checkSession())
        {
            throw new ArithmeticException();
        }
    }
    @Test(priority = 1)
    public void checkCurrentUser()
    {
        caseInfo("2", "Check User Session");

        //Test Case 1 - Step c
        if(!mainPage.navTools().checkLabel())
        {
            throw new ArithmeticException();
        }
    }
}

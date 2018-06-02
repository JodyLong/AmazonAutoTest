package TestCases;

import Pages.MainPage;
import Pages.SignInPage;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.Test;

public class TestCase2 extends BasicTest
{
    @Page
    private MainPage mainPage;

    @Page
    private SignInPage signInPage;

    @Test(priority = 0)
    public void gotoSite()
    {
        //Test Case 2 - Step b
        caseInfo("1", "Go to www.amazon.ca");
        gotoURL();
        await().explicitlyFor(500);
    }

    @Test(priority = 1)
    public void checkCurrentUser()
    {
        //Test Case 2 - Step a
        caseInfo("2", "Check User Session");
        if(!mainPage.navTools().checkSession())
        {
            throw new ArithmeticException();
        }
    }

    @Test(priority = 2)
    public void checkLabel()
    {
        //Test Case 2 - Step c
        caseInfo("2", "Check Labels");
        if(!mainPage.navTools().checkLabel())
        {
            throw new ArithmeticException();
        }
    }

    @Test(priority = 3)
    public void login()
    {
        //Test Case 2 - Step d, e, f
        caseInfo("3", "Login with Credentials");
        signIn();
    }
}

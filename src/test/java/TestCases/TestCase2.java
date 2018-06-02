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
        caseInfo("1", "Go to www.amazon.ca");
        gotoURL();
        await().explicitlyFor(500);
    }

    @Test(priority = 1)
    public void checkCurrentUser()
    {
        caseInfo("2", "Check User Session");
        if(!mainPage.navTools().checkSession())
        {
            throw new ArithmeticException();
        }
    }

    @Test(priority = 2)
    public void login()
    {
        caseInfo("3", "Login with Credentials");
        signIn();
    }
}

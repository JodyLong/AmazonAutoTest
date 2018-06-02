package Modules;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;

import static org.fluentlenium.core.filter.FilterConstructor.*;
public class NavToolModule extends BasicModule
{
    public NavToolModule(WebElement element, FluentControl control, ComponentInstantiator instantiator)
    {
        super(element, control, instantiator);
    }
    /*
        Click Sign in button to navigate to sign in page
        Sign in methods are implemented in SignInModule
     */
    public void signIn()
    {
        FluentWebElement goSignIn = el("div", withId("nav-tools"));

        goSignIn = goSignIn.$("a").index(1)
                .el("span", withClass("nav-line-1"));

        //Hover on "Hello. Sign in" label to expand option list
        goSignIn.mouse().moveToElement();
        await().explicitlyFor(500);

        //Click "Sign In" button
        FluentWebElement signInButton = el("div", withId("nav-flyout-ya-signin"))
                .el("a")
               .el("span", withClass("nav-action-inner"));
        signInButton.click();

        System.out.println("Sign in - Sign in button clicked");

        //Check if the sign in button is still displayed to tell if the page is redirected or not
        //if the process takes over 5 sec, fail it.
        try
        {
            int i = 0;
            while (signInButton.displayed() && i<10)
            //while (goSignIn.displayed() && i<10)
            {
                await().explicitlyFor(500);
                i ++;
            }

            throw new ArithmeticException("Sign in - time out");
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            System.out.println("Sign in - Page redirected");
        }
    }
    /*
        Not used in test cases
     */
    public void signOut()
    {
        FluentWebElement goSignIn = el("div", withId("nav-tools"))
                .el("span", withClass("nav-line-1"));
        goSignIn.mouse().moveToElement();

        FluentWebElement button_SignOut = el("span", withClass("nav-text"), withText("Sign Out"));
        button_SignOut.click();
    }

    /*
        Check if any user is signed in by checking the "Hello. Sign in" label text
     */
    public boolean checkSession()
    {
        FluentWebElement helloLabel = el("div", withId("nav-tools"))
                .$("a").index(1)
                .el("span", withClass("nav-line-1"));

        if(helloLabel.text().contentEquals("Hello. Sign in"))
        {
            System.out.println("Check Session - No user logged in");
            return true;
        }
        else
        {
            System.out.println("Check Session - There is a logged in user");
            System.out.println(helloLabel.text());
            return false;
        }
    }

    /*
        Check for labels "Hello. Sign in" & "Your Account"
     */
    public boolean checkLabel()
    {
        boolean result = false;

        FluentWebElement helloLabel = el("div", withId("nav-tools"))
                .$("a").index(1)
                .el("span", withClass("nav-line-1"));

        FluentWebElement accountLabel = el("div", withId("nav-tools"))
                .$("a").index(1)
                .el("span", withClass("nav-line-2"));

        if(helloLabel.text().contentEquals("Hello. Sign in"))
        {
            if(accountLabel.text().contentEquals("Your Account"))
            {
                System.out.println("Check Label - Labels displayed correctly");
                result = true;
                return result;
            }
        }
        System.out.println("Check Label - Labels displayed wrong");
        return result;
    }

}

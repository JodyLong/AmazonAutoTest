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

    public void signIn()
    {
        FluentWebElement goSignIn = el("div", withId("nav-tools"));

        goSignIn = goSignIn.$("a").index(1)
                .el("span", withClass("nav-line-1"));

        goSignIn.mouse().moveToElement();
        await().explicitlyFor(500);

        FluentWebElement signInButton = el("div", withId("nav-flyout-ya-signin"))
                .el("a")
               .el("span", withClass("nav-action-inner"));
        signInButton.click();

        System.out.println("Sign in - Sign in button clicked");
        try
        {
            int i = 0;
            while (signInButton.displayed() && i<10)
            //while (goSignIn.displayed() && i<10)
            {
                await().explicitlyFor(500);
                i ++;
            }
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            System.out.println("Sign in - Page redirected");
        }
    }

    public void signOut()
    {
        FluentWebElement goSignIn = el("div", withId("nav-tools"))
                .el("span", withClass("nav-line-1"));
        goSignIn.mouse().moveToElement();

        FluentWebElement button_SignOut = el("span", withClass("nav-text"), withText("Sign Out"));
        button_SignOut.click();
    }

    public boolean checkSession()
    {
        FluentWebElement helloLabel = el("div", withId("nav-tools"))
                .$("a").index(1)
                .el("span", withClass("nav-line-1"));


        //if(helloLabel.text() == "Hello. Sign in")
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

    public boolean checkLabel()
    {
        boolean result = false;
        FluentWebElement helloLabel = el("div", withId("nav-tools"))
                .el("span", withClass("nav-line-1"));

        FluentWebElement accountLabel = el("div", withId("nav-tools"))
                .el("span", withClass("nav-line-2"));
        if(helloLabel.text() == "Hello. Sign in")
        {
            if(accountLabel.text() == "Your Account")
            {
                System.out.println("Check Label - Labels displayed correctly");
                result = true;
            }
        }
        System.out.println("Check Label - Labels displayed wrong");
        return result;
    }

}

package Modules;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class SignInModule extends BasicModule
{
    public SignInModule(WebElement element, FluentControl control, ComponentInstantiator instantiator)
    {
        super(element, control, instantiator);
    }

    public SignInModule fillInEmailAddr(String emailAddr)
    {
        FluentWebElement input_EmailAddr = el("input", withId("ap_email"));
        input_EmailAddr.fill().withText(emailAddr);

        FluentWebElement button_Continue = el("input", withId("continue"));
        button_Continue.click();

        await().explicitlyFor(500);
        System.out.println("Email Addr filled: "+ emailAddr);
        return this;
    }

    public void fillInPassword(String password)
    {
        FluentWebElement input_EmailAddr = el("input", withId("ap_password"));
        input_EmailAddr.fill().withText(password);
        System.out.println("Password filled: "+ password);

        FluentWebElement button_SignIn = el("input", withId("signInSubmit"));
        button_SignIn.click();
        System.out.println("Sign in confirmed");
    }
}

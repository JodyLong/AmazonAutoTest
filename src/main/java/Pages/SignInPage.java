package Pages;

import Modules.SignInModule;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasicPage
{
    @FindBy(tagName = "Body")
    private SignInModule signInModule;

    public SignInModule signIn()
    {
        return signInModule;
    }
}

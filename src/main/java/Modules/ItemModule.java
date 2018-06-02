package Modules;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class ItemModule extends BasicModule
{
    public ItemModule(WebElement element, FluentControl control, ComponentInstantiator instantiator)
    {
        super(element, control, instantiator);
    }
    /*
        On the item page, click "Add to Cart" button
     */
    public void addToCart()
    {
        FluentWebElement button_addToCart = el("input", withId("add-to-cart-button"));
        button_addToCart.click();

    }
    /*
        After clicking "Add to Cart" button, click "Proceed to Checkout" button
     */
    public void proceedToCheckout()
    {
        FluentWebElement button_proceedToCheckout = el("span", withId("hlb-ptc-btn"));
        button_proceedToCheckout.click();
    }


}

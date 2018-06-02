package Modules;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.domain.FluentList;
import org.openqa.selenium.WebElement;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class SearchModule extends BasicModule
{
    public SearchModule(WebElement element, FluentControl control, ComponentInstantiator instantiator)
    {
        super(element, control, instantiator);
    }

    /*
        Input keyword in the searchbar on main page, then click submit button
     */
    public void searchFor(String keyword)
    {
        FluentWebElement searchBar = el("input", withId("twotabsearchtextbox"));

        searchBar.fill().withText(keyword);

        FluentWebElement button_Submit = el("div",withClass("nav-right"))
                .el("input", withClass("nav-input"));

        button_Submit.click();
    }

    /*
        Check if the result page is actually displaying the results for the original keyword or corrected keyword
     */
    public boolean checkErrorMsg()
    {
        try {
            FluentWebElement errorMsg = el("span", withId("didYouMean"));
            System.out.println("Message detected: " + errorMsg.text());

            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            // no error message detected
            System.out.println("No message detected");
            return false;
        }
    }

    /*
        Print out all displaying item names in result page - only for the first page
     */
    public void checkResults()
    {
        FluentWebElement resultTable = el("ul", withId("s-results-list-atf"));
        FluentList resultList = resultTable.$("h2");

        for(int i = 0; i < resultList.count(); i++)
        {
            String itemName;
            resultList.index(i).scrollIntoView();
            //itemName = resultList.index(i)
            //       .el("h2").text();
            itemName = resultList.index(i).text();
            System.out.println("Result ["+ (i+1) +"]: " + itemName);
        }
    }
    /*
        Go to the item detail page by clicking the label
     */
    public void gotoResult(String itemName)
    {
        FluentWebElement targetItem = el("h2", withText(itemName));
        targetItem.scrollIntoView();
        targetItem.click();
    }
}

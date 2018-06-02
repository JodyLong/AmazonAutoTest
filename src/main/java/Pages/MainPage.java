package Pages;
import Modules.ItemModule;
import Modules.NavToolModule;
import Modules.SearchModule;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasicPage
{
    //@FindBy(id = "nav-tools")
    @FindBy(tagName = "body")
    private NavToolModule navToolModule;

    @FindBy(id = "nav-search")
    private SearchModule searchBarModule;

    @FindBy(id = "a-page")
    private SearchModule searchResultModule;

    @FindBy(tagName = "body")
    private ItemModule itemModule;

    public NavToolModule navTools()
    {
        return navToolModule;
    }

    public SearchModule searchBar()
    {
        return searchBarModule;
    }

    public SearchModule searchResults()
    {
        return searchResultModule;
    }

    public ItemModule item()
    {
        return itemModule;
    }
}

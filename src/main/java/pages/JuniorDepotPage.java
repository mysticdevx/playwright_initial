package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class JuniorDepotPage {
    private final Page juniorDepotPage;
    // TODO: regular expression coud be used for different environments
    public final String pageUrl = "https://www.visualvest.de/geldanlage/junior-depot.html";

    public JuniorDepotPage(Page page) {
        this.juniorDepotPage = page;
    }

    public Locator pageHeadline() {
        return juniorDepotPage.locator("h1");
    }
}

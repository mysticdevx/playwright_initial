package pages;

import com.microsoft.playwright.Page;

public class AccountNavigationPage {
    private final Page accountNavigationPage;
    private static final String ACCOUNT_BUTTON = "button[data-lid='hdr_signin']";

    public AccountNavigationPage(Page page) {
        this.accountNavigationPage = page;
    }

    public void navigateTo(String location) {
        accountNavigationPage.locator(ACCOUNT_BUTTON).click();
        accountNavigationPage.locator(String.format("//div[@class='account-menu']//a[text() = '%s']", location)).click();
    }
}

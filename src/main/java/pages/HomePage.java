package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private final Page homePage;

    private static final String popupVisible = ".flyout-content .list--visible";
    private static final String popupVisibleSubMenus = ".flyout-content .list--visible span.submenu-title";

    public HomePage(Page page){
        this.homePage=page;
    }

    public Locator popupMenuContainer(){
        return homePage.locator(popupVisible);
    }

    public Locator popupMenuSubtitles(){
        return homePage.locator(popupVisible);
    }



    public void hoverOverTopMenu(String location){
        homePage.locator(String.format("button:has-text('%s')",location)).hover();
    }

    public void clickSubmenuItem(String location){
        homePage.locator(String.format(".list--visible a:has-text('%s')",location)).click();
    }

    //TODO: handle it with add cookies method
    public void denyCookies( ){
        homePage.locator("css=[data-testid=\"uc-deny-all-button\"]").click();
    }
}

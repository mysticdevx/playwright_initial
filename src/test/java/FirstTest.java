import Utilities.ConfigurationReader;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FirstTest extends PlaywrightRunner {

    @Test
    @Disabled
    public void firstTest() {

        page.navigate(ConfigurationReader.getProperty("url"));

        // page.locator("//a[@data-lid='hdr_td_topdeals']").click();
        // page.locator("[data-lid=hdr_td_topdeals]").click();
        //page.locator("a:has-text(\"Deal of the Day\")").click();

        Locator menuItems = page.locator("ul.bottom-nav-left li a");
        // System.out.println(menuItems.allTextContents());

        for (int i = 0; i < menuItems.count(); i++) {
            System.out.println(menuItems.nth(i).textContent());
        }

        System.out.println();
    }
}

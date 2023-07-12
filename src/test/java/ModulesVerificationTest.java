import Utilities.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ModulesVerificationTest extends PlaywrightRunner {

    @Test
    public void GeldanlageTest() {
        String url = ConfigurationReader.getProperty("url");
        page.navigate(url);

        homePage.denyCookies();

        homePage.hoverOverTopMenu("Geldanlage");

        assertThat(homePage.popupMenuContainer()).isVisible();
/*
        String[] expectedSubtitles = {"Unsere Geldanlagen", "Globales ETF-Portfolio", "Nachhaltiges Portfolio", "Sparen für Kinder", "Altersvorsorge"};

        assertThat(homePage.popupMenuSubtitles()).hasText(expectedSubtitles);
        Expected :[Unsere Geldanlagen, Globales ETF-Portfolio, Nachhaltiges Portfolio, Sparen für Kinder, Altersvorsorge]
        Actual:[Unsere GeldanlagenGlobales ETF-PortfolioNachhaltiges PortfolioSparen für KinderAltersvorsorge]
         */

        homePage.clickSubmenuItem("Sparen für Kinder");
        assertThat(page).hasURL(juniorDepotPage.pageUrl);
        assertThat(juniorDepotPage.pageHeadline()).hasText("JUNIOR-DEPOT");
    }

    @Test
    public void SpecialTest() {
        String url = ConfigurationReader.getProperty("url");
        page.navigate(url);

        homePage.denyCookies();

        homePage.hoverOverTopMenu("Specials");

        assertThat(homePage.popupMenuContainer()).isVisible();
/*
        String[] expectedSubtitles = {"Unsere Geldanlagen", "Globales ETF-Portfolio", "Nachhaltiges Portfolio", "Sparen für Kinder", "Altersvorsorge"};

        assertThat(homePage.popupMenuSubtitles()).hasText(expectedSubtitles);
        Expected :[Unsere Geldanlagen, Globales ETF-Portfolio, Nachhaltiges Portfolio, Sparen für Kinder, Altersvorsorge]
        Actual:[Unsere GeldanlagenGlobales ETF-PortfolioNachhaltiges PortfolioSparen für KinderAltersvorsorge]
         */

        homePage.clickSubmenuItem("Geschenksparen");
        assertThat(page).hasURL(juniorDepotPage.pageUrl);

    }
}

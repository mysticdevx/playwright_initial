import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AccountNavigationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.JuniorDepotPage;

import java.nio.file.Paths;
import java.util.Arrays;


@ExtendWith(TestWatcherExtension.class)
public class PlaywrightRunner {

    protected Page page;
    protected Browser browser;
    protected BrowserContext browserContext;

    protected static Playwright playwright;
    protected CreateAccountPage createAccountPage;
    protected AccountNavigationPage accountNavigationPage;
    protected HomePage homePage;
    protected JuniorDepotPage juniorDepotPage;

    @BeforeAll
    public static void init() {
        playwright = Playwright.create();
    }

    @BeforeEach
    public void setUp() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setPermissions(Arrays.asList("geolocation"))
//                .setRecordVideoDir(Paths.get("videos/"))
//                .setRecordVideoSize(1920, 1680)
        );
        page = browserContext.newPage();

        // start tracing
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        createAccountPage = new CreateAccountPage(page);
        accountNavigationPage = new AccountNavigationPage(page);
        homePage= new HomePage(page);
        juniorDepotPage = new JuniorDepotPage(page);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        // stop tracing
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace/" + testInfo.getDisplayName().replace("()", "") + ".zip")));
        browserContext.close();
        browser.close();
    }
}

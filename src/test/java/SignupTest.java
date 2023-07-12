import Utilities.ConfigurationReader;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import java.util.Arrays;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SignupTest extends PlaywrightRunner {
    @Test
    @Disabled
    public void signUpTest() {

        String url = ConfigurationReader.getProperty("url");
        page.navigate(url);

        accountNavigationPage.navigateTo("Create Account");
        createAccountPage.createAccount();

    }
}

package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.microsoft.playwright.*;


public class Hooks {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;

    @Before
    public void setUp() {
        System.out.println("Cucumber @Before hook: Setting up Playwright");
        playwright = Playwright.create();
        // Pass the '--start-maximized' argument:
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(100);

        browser = playwright.chromium().launch(options);
        // Optionally create a context now, or each scenario can create it later
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
    }

    @After
    public void tearDown() {
        System.out.println("Cucumber @After hook: Tearing down Playwright");
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
